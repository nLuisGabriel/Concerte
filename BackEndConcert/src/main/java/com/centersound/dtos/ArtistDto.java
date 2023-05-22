package com.centersound.dtos;

import com.centersound.enums.Gender;
import com.centersound.enums.GeographicRegion;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Objects;

public class ArtistDto {
    private Long id;
    private String name;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate;
    private Gender gender;
    private GeographicRegion geographicRegion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public GeographicRegion getGeographicRegion() {
        return geographicRegion;
    }

    public void setGeographicRegion(GeographicRegion geographicRegion) {
        this.geographicRegion = geographicRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistDto artistDto = (ArtistDto) o;
        return Objects.equals(id, artistDto.id) && Objects.equals(name, artistDto.name) && Objects.equals(description, artistDto.description) && Objects.equals(birthDate, artistDto.birthDate) && gender == artistDto.gender && geographicRegion == artistDto.geographicRegion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, birthDate, gender, geographicRegion);
    }
}
