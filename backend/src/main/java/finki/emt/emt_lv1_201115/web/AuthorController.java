package finki.emt.emt_lv1_201115.web;

import finki.emt.emt_lv1_201115.model.domain.Author;
import finki.emt.emt_lv1_201115.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/all")
    public List<Author> getAllAuthors(){
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id){
        return this.authorService.findById(id);
    }
}
