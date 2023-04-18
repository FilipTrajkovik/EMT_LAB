package finki.emt.emt_lv1_201115.service.impl;

import finki.emt.emt_lv1_201115.model.Exceptions.InvalidCountryIdException;
import finki.emt.emt_lv1_201115.model.domain.Country;
import finki.emt.emt_lv1_201115.repository.CountryRepository;
import finki.emt.emt_lv1_201115.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.of(this.countryRepository.findById(id).orElseThrow(() -> new InvalidCountryIdException(id)));
    }
}
