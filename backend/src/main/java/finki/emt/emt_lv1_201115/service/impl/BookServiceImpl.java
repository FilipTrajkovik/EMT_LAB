package finki.emt.emt_lv1_201115.service.impl;

import finki.emt.emt_lv1_201115.model.Exceptions.InvalidAuthorIdException;
import finki.emt.emt_lv1_201115.model.Exceptions.InvalidBookIdException;
import finki.emt.emt_lv1_201115.model.Exceptions.NoneCopiesOfBookLeftException;
import finki.emt.emt_lv1_201115.model.domain.Author;
import finki.emt.emt_lv1_201115.model.domain.Book;
import finki.emt.emt_lv1_201115.model.dto.BookDto;
import finki.emt.emt_lv1_201115.repository.AuthorRepository;
import finki.emt.emt_lv1_201115.repository.BookRepository;
import finki.emt.emt_lv1_201115.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.of(this.bookRepository.findById(id).orElseThrow(() -> new InvalidBookIdException(id)));
    }

    @Override
    public Page<Book> findAllPageable(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> add(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(()-> new InvalidAuthorIdException(bookDto.getAuthorId()));
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> deleteById(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(()->new InvalidBookIdException(id));

        this.bookRepository.deleteById(id);

        return Optional.of(book);

    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(()-> new InvalidBookIdException(bookDto.getAuthorId()));
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new InvalidBookIdException(id));

        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> markAsRented(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new InvalidBookIdException(id));

        if (book.getAvailableCopies() > 0)
            book.setAvailableCopies(book.getAvailableCopies()-1);
        else
            throw new NoneCopiesOfBookLeftException();

        this.bookRepository.save(book);

        return Optional.of(book);
    }
}
