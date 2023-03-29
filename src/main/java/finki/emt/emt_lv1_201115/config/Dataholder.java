package finki.emt.emt_lv1_201115.config;

import finki.emt.emt_lv1_201115.model.domain.Author;
import finki.emt.emt_lv1_201115.model.domain.Book;
import finki.emt.emt_lv1_201115.model.domain.Country;
import finki.emt.emt_lv1_201115.model.enumeration.Category;
import finki.emt.emt_lv1_201115.repository.AuthorRepository;
import finki.emt.emt_lv1_201115.repository.BookRepository;
import finki.emt.emt_lv1_201115.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Dataholder {

    private List<Author> authors = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Country> countries = new ArrayList<>();

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    public Dataholder(AuthorRepository authorRepository, BookRepository bookRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void OnInit() {
        Country country1 = new Country("Macedonia", "Europe");
        Country country2 = new Country("Great Britain", "Europe");
        Country country3 = new Country("Egypt", "Africa");
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
        countryRepository.saveAll(countries);

        Author author1 = new Author("Filip", "Trajkovik", country1);
        Author author2 = new Author("Jovan", "Jovanovski", country2);
        Author author3 = new Author("Stefanija", "Stefanovska", country3);
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authorRepository.saveAll(authors);

        Book book1 = new Book("Book1", Category.CLASSICS, author1, 10);
        Book book2 = new Book("Book2", Category.NOVEL, author2, 20);
        Book book3 = new Book("Book3", Category.THRILLER, author3, 30);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        bookRepository.saveAll(books);
    }
}
