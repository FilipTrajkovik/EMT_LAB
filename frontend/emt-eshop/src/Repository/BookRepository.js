import axios from '../custom-axios/axios';

const BookService = {

    fetchCategories: () => {
        return axios.get("/book/categories");
    },
    fetchBooks: () => {
        return axios.get("/book/all");
    },
    fetchAuthors: () => {
        return axios.get("/author/all");
    },
    addBook: (name, category, authorId, availableCopies) => {
        return axios.post("/book/add",{
            "name" : name,
            "category" : category,
            "authorId" : authorId,
            "availableCopies" : availableCopies,
        })
    },
    editBook: (id,name, category, authorId, availableCopies) => {

        return axios.put(`/book/edit/${id}`, {
            "name": name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        });

    },
    getBook: (id) => {
        return axios.get(`/book/${id}`);
    },
    deleteBook: (id) => {
        return axios.delete(`/book/delete/${id}`)
    },
    markAsTaken: (id) => {
        return axios.post(`/book/markAsRented/${id}`)
    }

}

export default BookService;
