import logo from '../logo.svg';
import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import Header from "../Header/header";
import Categories from "../Categories/categories";
import BookRepository from "../Repository/BookRepository";
import BookList from "../Books/BookList/bookList";
import BookAdd from "../Books/BookAdd/bookAdd";
import BookEdit from "../Books/BookEdit/bookEdit";

class App extends Component{

    constructor(props) {
        super(props);
        this.state = {
            categories: [],
            books: [],
            authors: [],
            selectedBook: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className={"container"}>
                        <Routes>
                            <Route path={"/books"} exact
                                   element={<BookList books={this.state.books} onEdit={this.getBook} onDelete={this.deleteBook} onMarkAsTaken={this.markAsTaken}/>}/>
                            <Route path={"/categories"} exact
                                   element={<Categories categories={this.state.categories}/>}/>
                            <Route path={"/books/add"} exact
                                   element={<BookAdd categories={this.state.categories} authors={this.state.authors}
                                                        onAddBook={this.addBook}
                                   />}/>
                            <Route path={"/books/edit/:id"} exact
                                   element={<BookEdit categories={this.state.categories} authors={this.state.authors}
                                                         onEditBook={this.editBook} book={this.state.selectedBook}
                                   />}/>
                        </Routes>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.fetchData()
    }

    loadCategories = () => {
        BookRepository.fetchCategories()
            .then((data) => {
                this.setState({
                    categories: data.data
                })
            });
    }

    loadBooks = () => {
        BookRepository.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadAuthors = () => {
        BookRepository.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }

    addBook = (name, category, authorId, availableCopies) => {
        BookRepository.addBook(name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    editBook = (id, name, category, authorId, availableCopies) => {
        BookRepository.editBook(id, name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

    deleteBook = (id) => {
        BookRepository.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    markAsTaken = (id) => {
        BookRepository.markAsTaken(id)
            .then(() => {
                this.loadBooks();
            })
    }

    getBook = (id) => {
        BookRepository.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }

    fetchData = () => {
        this.loadCategories();
        this.loadBooks();
        this.loadAuthors();
    }

}

export default App;