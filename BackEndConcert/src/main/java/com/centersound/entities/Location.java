package com.centersound.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="country", nullable = false)
    private String country;
    @Column(name="county", nullable = false)
    private String county;
    @Column(name="town", nullable = false)
    private String town;
    @Column(name="street", nullable = false)
    private String street;
    @Column(name="streetNumber", nullable = false)
    private Integer streetNumber;

    @OneToOne(mappedBy = "location")
    private Concert concert;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) && Objects.equals(country, location.country) && Objects.equals(county, location.county) && Objects.equals(town, location.town) && Objects.equals(street, location.street) && Objects.equals(streetNumber, location.streetNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, county, town, street, streetNumber);
    }
}
