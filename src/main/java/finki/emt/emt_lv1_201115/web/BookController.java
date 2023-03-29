package finki.emt.emt_lv1_201115.web;

import finki.emt.emt_lv1_201115.model.domain.Author;
import finki.emt.emt_lv1_201115.model.domain.Book;
import finki.emt.emt_lv1_201115.model.dto.BookDto;
import finki.emt.emt_lv1_201115.repository.BookRepository;
import finki.emt.emt_lv1_201115.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/pageable")
    public Page<Book> getAllBooksPageable(Pageable pageable){
        return this.bookService.findAllPageable(pageable);
    }

    @GetMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDto bookDto){
        return this.bookService.add(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id){
        Optional<Book> book = this.bookService.deleteById(id);

        if(book.isPresent())
            return ResponseEntity.ok(book.get());

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/markAsRented/{id}")
    public ResponseEntity<Book> markBookAsRented(@PathVariable Long id){
        return this.bookService.markAsRented(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
