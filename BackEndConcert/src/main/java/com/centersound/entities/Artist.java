package com.centersound.entities;

import com.centersound.enums.Gender;
import com.centersound.enums.GeographicRegion;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="name", nullable = false)
    String name;
    @Column(name="description", nullable = false)
    String description;
    @Column(name="birthDate", nullable = false)
    LocalDate birthDate;
    @Enumerated(value = EnumType.STRING)
    Gender gender;
    @Enumerated(value = EnumType.STRING)
    GeographicRegion geographicRegion;

    @ManyToMany(mappedBy = "artists")
    Set<Concert> concerts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(Set<Concert> concerts) {
        this.concerts = concerts;
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
        if (!(o instanceof Artist)) return false;
        Artist artist = (Artist) o;
        return Objects.equals(getName(), artist.getName()) && Objects.equals(getDescription(), artist.getDescription()) && Objects.equals(getBirthDate(), artist.getBirthDate()) && getGender() == artist.getGender() && getGeographicRegion() == artist.getGeographicRegion();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getBirthDate(), getGender(), getGeographicRegion());
    }
}
