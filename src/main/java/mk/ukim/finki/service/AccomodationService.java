package mk.ukim.finki.service;

import mk.ukim.finki.model.Accommodation;
import mk.ukim.finki.model.dto.AccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccomodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById();
    Optional <Accommodation> save (AccommodationDto accommodationDto);
    Optional <Accommodation> update (Long id, AccommodationDto accommodationDto);
    void delete (Long id, AccommodationDto accommodationDto);
}
