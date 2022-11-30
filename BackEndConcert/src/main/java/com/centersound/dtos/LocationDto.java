package com.centersound.dtos;

import javax.persistence.Column;
import java.util.Objects;

public class LocationDto {
    private Long id;
    private String country;
    private String county;
    private String town;
    private String street;
    private Integer streetNumber;

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
        LocationDto that = (LocationDto) o;
        return Objects.equals(id, that.id) && Objects.equals(country, that.country) && Objects.equals(county, that.county) && Objects.equals(town, that.town) && Objects.equals(street, that.street) && Objects.equals(streetNumber, that.streetNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, county, town, street, streetNumber);
    }
}
