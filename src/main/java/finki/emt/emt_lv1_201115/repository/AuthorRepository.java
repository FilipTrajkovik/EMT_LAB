package finki.emt.emt_lv1_201115.repository;

import finki.emt.emt_lv1_201115.model.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
