package mk.ukim.finki.service;

import mk.ukim.finki.model.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccomodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> update(Long id, Accommodation accommodation);

    Optional<Accommodation> save(Accommodation accommodation);

    void deleteById(Long id);
    Optional<Accommodation> rentRoom(Long id);

}
