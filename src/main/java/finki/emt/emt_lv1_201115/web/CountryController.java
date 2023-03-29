package finki.emt.emt_lv1_201115.web;

import finki.emt.emt_lv1_201115.model.domain.Country;
import finki.emt.emt_lv1_201115.repository.CountryRepository;
import finki.emt.emt_lv1_201115.service.CountryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public List<Country> getAllCountries() {
        return this.countryService.findAll();
    }
}
