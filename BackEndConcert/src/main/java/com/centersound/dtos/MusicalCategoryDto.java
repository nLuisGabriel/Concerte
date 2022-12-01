package com.centersound.dtos;

import com.centersound.enums.Category;

import java.util.Objects;


public class MusicalCategoryDto {
    Long id;
    Category category;

    String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicalCategoryDto that = (MusicalCategoryDto) o;
        return Objects.equals(id, that.id) && category == that.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category);
    }
}
