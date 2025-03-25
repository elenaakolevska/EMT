package mk.ukim.finki.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.dto.AccommodationDto;
import mk.ukim.finki.model.Accommodation;
import mk.ukim.finki.model.CategoryAcc;
import mk.ukim.finki.model.Country;
import mk.ukim.finki.model.Host;
import mk.ukim.finki.repository.CountryRepository;
import mk.ukim.finki.repository.HostRepository;
import mk.ukim.finki.web.AccommodationController;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final AccommodationController accommodationController;
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(AccommodationController accommodationController, HostRepository hostRepository, CountryRepository countryRepository) {
        this.accommodationController = accommodationController;
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
    }
    @PostConstruct
    public void init() {
        Country c1=countryRepository.save(new Country("Macedonia","Europe"));
        Country c2= countryRepository.save(new Country("Japan","Asia"));

        Host h1= hostRepository.save(new Host("Dimitar","Iliev",c1));
        Host h2=hostRepository.save(new Host("Mila","Ilieva",c2));

        accommodationController.save(new Accommodation("Family", CategoryAcc.APARTMENT,4,h1));
        accommodationController.save(new Accommodation("Solo", CategoryAcc.FLAT,1,h2));

    }

}
