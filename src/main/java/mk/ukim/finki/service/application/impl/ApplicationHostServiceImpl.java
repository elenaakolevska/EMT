package mk.ukim.finki.service.application.impl;

import mk.ukim.finki.dto.create.CreateHostDto;
import mk.ukim.finki.dto.display.DisplayHostDto;
import mk.ukim.finki.model.projections.HostByCountry;
import mk.ukim.finki.model.projections.HostNameProjection;
import mk.ukim.finki.service.application.ApplicationHostService;
import mk.ukim.finki.service.domain.HostService;
import mk.ukim.finki.events.HostChangedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationHostServiceImpl implements ApplicationHostService {

    private final HostService hostService;
    private final ApplicationEventPublisher eventPublisher;

    public ApplicationHostServiceImpl(HostService hostService,
                                      ApplicationEventPublisher eventPublisher) {
        this.hostService = hostService;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return  hostService.findAll().stream()
                .map(DisplayHostDto::from)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto host) {
        Optional<DisplayHostDto> updated = hostService.update(id,host.toHost())
                .map(DisplayHostDto::from);

        updated.ifPresent(dto -> eventPublisher.publishEvent(new HostChangedEvent(this)));

        return updated;
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto host) {
        Optional<DisplayHostDto> saved = hostService.save(host.toHost())
                .map(DisplayHostDto::from);

        saved.ifPresent(dto -> eventPublisher.publishEvent(new HostChangedEvent(this)));

        return saved;
    }

    @Override
    public void deleteById(Long id) {
        hostService.deleteById(id);
        eventPublisher.publishEvent(new HostChangedEvent(this));
    }

    @Override
    public List<HostByCountry> getHostCountByCountry() {
        return hostService.getHostCountByCountry();
    }

    @Override
    public List<HostNameProjection> getAllHostNames() {
        return hostService.getAllHostNames();
    }

}
