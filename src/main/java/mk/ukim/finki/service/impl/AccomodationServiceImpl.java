package mk.ukim.finki.service.impl;

import mk.ukim.finki.model.Accommodation;
import mk.ukim.finki.repository.AccommodationRepository;
import mk.ukim.finki.service.AccomodationService;
import mk.ukim.finki.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccomodationServiceImpl implements AccomodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostService hostService;
    public AccomodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return Optional.of(accommodationRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {

        return accommodationRepository.findById(id)
                .map(existingAccommodation -> {
                    if (accommodation.getName() != null) {
                        existingAccommodation.setName(accommodation.getName());
                    }
                    if (accommodation.getCategory() != null ) {
                        existingAccommodation.setCategory(accommodation.getCategory());
                    }
                    if (accommodation.getNumRooms() != null ) {
                        existingAccommodation.setNumRooms(accommodation.getNumRooms());
                    }
                    if (accommodation.getHost() != null && hostService.findById(accommodation.getHost().getId()).isPresent()) {
                        existingAccommodation.setHost(accommodation.getHost());
                    }
                    return accommodationRepository.save(existingAccommodation);
                });

    }

    @Override
    public Optional<Accommodation> save(Accommodation accommodation) {

        if (accommodation.getCategory()!=null && accommodation.getName()!=null && accommodation.getNumRooms()!=null &&
                hostService.findById(accommodation.getHost().getId()).isPresent()){
            return Optional.of(accommodationRepository.save(new Accommodation(
                    accommodation.getName(),
                    accommodation.getCategory(),
                    accommodation.getNumRooms(),
                    accommodation.getHost()
            )));
        }

        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

    @Override
    public Optional<Accommodation> rentRoom(Long id) {
        return accommodationRepository.findById(id).map(existingAccommodation->{
            if(existingAccommodation.getNumRooms()>0)
                existingAccommodation.setNumRooms(existingAccommodation.getNumRooms()-1);
            return accommodationRepository.save(existingAccommodation);
        });
    }
}
