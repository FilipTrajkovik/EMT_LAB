package finki.emt.emt_lv1_201115.service;

import finki.emt.emt_lv1_201115.model.domain.Book;
import finki.emt.emt_lv1_201115.model.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Page<Book> findAllPageable(Pageable pageable);

    Optional<Book> add(BookDto bookDto);

    Optional<Book> deleteById(Long id);

    Optional<Book> edit(Long id, BookDto bookDto);

    Optional<Book> markAsRented(Long id);
}
