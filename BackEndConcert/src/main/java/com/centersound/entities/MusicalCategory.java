package com.centersound.entities;

import com.centersound.enums.Category;

import javax.persistence.*;

@Entity
@Table(name="musical_category")
public class MusicalCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="category")
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name = "description")
    private String details;

    @OneToOne(mappedBy = "category")
    private Concert concert;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
