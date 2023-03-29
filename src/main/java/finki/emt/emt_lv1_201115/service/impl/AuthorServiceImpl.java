package finki.emt.emt_lv1_201115.service.impl;

import finki.emt.emt_lv1_201115.model.Exceptions.InvalidAuthorIdException;
import finki.emt.emt_lv1_201115.model.domain.Author;
import finki.emt.emt_lv1_201115.repository.AuthorRepository;
import finki.emt.emt_lv1_201115.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.of(this.authorRepository.findById(id).orElseThrow(() -> new InvalidAuthorIdException(id)));
    }
}
