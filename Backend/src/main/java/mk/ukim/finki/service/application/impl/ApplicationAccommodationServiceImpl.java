package mk.ukim.finki.service.application.impl;

import mk.ukim.finki.dto.CategoryCountDTO;
import mk.ukim.finki.dto.create.CreateAccommodationDto;
import mk.ukim.finki.dto.display.DisplayAccommodationDto;
import mk.ukim.finki.dto.display.DisplayAccommodationsByHostDto;
import mk.ukim.finki.model.domain.Accommodation;
import mk.ukim.finki.model.domain.Host;
import mk.ukim.finki.repository.HostRepository;
import mk.ukim.finki.service.application.ApplicationAccommodationService;
import mk.ukim.finki.service.domain.AccomodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationAccommodationServiceImpl implements ApplicationAccommodationService {

    private final AccomodationService accomodationService;
    private final HostRepository hostRepository;

    public ApplicationAccommodationServiceImpl(AccomodationService accomodationService, HostRepository hostRepository) {
        this.accomodationService = accomodationService;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return accomodationService.findAll().stream()
                .map(DisplayAccommodationDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accomodationService.findById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto dto) {
        Host host = hostRepository.findById(dto.hostId())
                .orElseThrow(() -> new RuntimeException("Host not found"));

        Accommodation updated = new Accommodation(
                dto.name(),
                dto.category(),
                dto.numRooms(),
                host
        );

        return accomodationService.update(id, updated)
                .map(DisplayAccommodationDto::from);
    }


    @Override
    public Optional<DisplayAccommodationDto> save(CreateAccommodationDto dto) {
        Host host = hostRepository.findById(dto.hostId())
                .orElseThrow(() -> new RuntimeException("Host not found"));

        Accommodation accommodation = new Accommodation(
                dto.name(),
                dto.category(),
                dto.numRooms(),
                host
        );

        return accomodationService.save(accommodation)
                .map(DisplayAccommodationDto::from);
    }



    @Override
    public void deleteById(Long id) {
        accomodationService.deleteById(id);
    }

    @Override
    public Optional<DisplayAccommodationDto> rentRoom(Long id) {
        return accomodationService.rentRoom(id)
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public List<CategoryCountDTO> countByCategoryAcc() {
        return accomodationService.countByCategory();
    }



    @Override
    public List<DisplayAccommodationsByHostDto> getAccommodationStatsPerHost() {
        return accomodationService.getAccommodationStatsPerHost().stream()
                .map(accommodation -> new DisplayAccommodationsByHostDto(
                        accommodation.getName(),
                        accommodation.getSurname(),
                        accommodation.getNumAccommodations()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayAccommodationDto> details(Long id) {
        return accomodationService.findById(id).map(DisplayAccommodationDto::from);

    }

}
