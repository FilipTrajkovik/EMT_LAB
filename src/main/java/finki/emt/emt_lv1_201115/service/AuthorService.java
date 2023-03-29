package finki.emt.emt_lv1_201115.service;

import finki.emt.emt_lv1_201115.model.domain.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService{

    List<Author> findAll();

    Optional<Author> findById(Long id);
}
