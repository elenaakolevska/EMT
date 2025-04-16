package mk.ukim.finki.service.application;

import mk.ukim.finki.dto.create.CreateHostDto;
import mk.ukim.finki.dto.display.DisplayHostDto;
import mk.ukim.finki.model.domain.Host;

import java.util.List;
import java.util.Optional;

public interface ApplicationHostService {
    List<DisplayHostDto> findAll();

    Optional<DisplayHostDto> findById(Long id);

    Optional<DisplayHostDto> update(Long id, CreateHostDto host);

    Optional<DisplayHostDto> save(CreateHostDto host);

    void deleteById(Long id);
}
