package mk.ukim.finki.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.model.CategoryAcc;
import mk.ukim.finki.model.Host;

@Data
public class AccommodationDto {
    private String name;
    private CategoryAcc category;
    private Integer numRooms;
    private Long hostId;

    public AccommodationDto(String name, CategoryAcc category, Integer numRooms, Long hostId) {
        this.name = name;
        this.category = category;
        this.numRooms = numRooms;
        this.hostId = hostId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryAcc getCategory() {
        return category;
    }

    public void setCategory(CategoryAcc category) {
        this.category = category;
    }

    public Integer getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(Integer numRooms) {
        this.numRooms = numRooms;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }
}