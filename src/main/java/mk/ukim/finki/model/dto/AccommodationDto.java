package mk.ukim.finki.model.dto;

import lombok.Data;
import mk.ukim.finki.model.CategoryAcc;

@Data
public class AccommodationDto {
    private String name;
    private Long host;
    private Integer numRooms;
    private CategoryAcc categoryAcc;
}
