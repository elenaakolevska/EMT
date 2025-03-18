package mk.ukim.finki.service;

import mk.ukim.finki.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    Optional<Country> findById();
    Optional <Country> save (AccommodationDto accommodationDto);
    Optional <Country> update (Long id, AccommodationDto accommodationDto);
    void delete (Long id, AccommodationDto accommodationDto);
}
