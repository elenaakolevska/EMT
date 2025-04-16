package mk.ukim.finki.dto.display;

import mk.ukim.finki.model.domain.Accommodation;
import mk.ukim.finki.model.domain.Host;
import mk.ukim.finki.model.enumerations.CategoryAcc;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAccommodationDto(Long id, String name, CategoryAcc category, Integer numRooms, Host host) {
    public static DisplayAccommodationDto from (Accommodation accommodation){
        return new DisplayAccommodationDto(accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getNumRooms(),
                accommodation.getHost());
    }
    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations){
        return accommodations.stream().map(DisplayAccommodationDto::from).collect(Collectors.toList());
    }
}
