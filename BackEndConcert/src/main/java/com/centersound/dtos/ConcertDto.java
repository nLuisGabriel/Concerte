package com.centersound.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConcertDto {
    private Long id;
    private LocationDto locationDto;
    private MusicalCategoryDto musicalCategoryDto;
    private String name;
    private LocalDateTime date;
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    public MusicalCategoryDto getMusicalCategoryDto() {
        return musicalCategoryDto;
    }

    public void setMusicalCategoryDto(MusicalCategoryDto musicalCategoryDto) {
        this.musicalCategoryDto = musicalCategoryDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
