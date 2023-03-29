package finki.emt.emt_lv1_201115.repository;

import finki.emt.emt_lv1_201115.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
