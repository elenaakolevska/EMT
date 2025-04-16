package mk.ukim.finki.service.application.impl;

import mk.ukim.finki.dto.create.CreateHostDto;
import mk.ukim.finki.dto.display.DisplayHostDto;
import mk.ukim.finki.service.application.ApplicationHostService;
import mk.ukim.finki.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationHostServiceImpl implements ApplicationHostService {

    private final HostService hostService;

    public ApplicationHostServiceImpl(HostService hostService) {
        this.hostService = hostService;
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
        return hostService.update(id,host.toHost())
                .map(DisplayHostDto::from);    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto host) {
        return hostService.save(host.toHost())
                .map(DisplayHostDto::from);
    }

    @Override
    public void deleteById(Long id) {
        hostService.deleteById(id);

    }
}
