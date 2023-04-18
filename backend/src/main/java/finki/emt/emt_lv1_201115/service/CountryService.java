package finki.emt.emt_lv1_201115.service;

import finki.emt.emt_lv1_201115.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);
}
