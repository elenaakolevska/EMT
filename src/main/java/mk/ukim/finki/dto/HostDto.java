package mk.ukim.finki.dto;

import jakarta.persistence.ManyToOne;
import mk.ukim.finki.model.Country;

public class HostDto {
    private String name;
    private String surname;
    private Long countryId;

    public HostDto(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }
}
