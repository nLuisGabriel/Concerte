package com.centersound.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="concerts")
public class Concert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    MusicalCategory category;

    @Column(name="name", nullable = false)
    String name;

    @Column(name="date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss", shape = JsonFormat.Shape.STRING)
    LocalDateTime date;

    @Column(name = "PRICE", scale = 2, nullable = false)
    BigDecimal price;

    @ManyToMany
    @JoinTable(
            name="concert_artist",
            joinColumns =  @JoinColumn(name="concert_id"),
            inverseJoinColumns = @JoinColumn(name="artist_id")
    )
    Set<Artist> artists;

    @OneToMany(mappedBy = "concert")
    Set<Order> orders;


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MusicalCategory getCategory() {
        return category;
    }

    public void setCategory(MusicalCategory category) {
        this.category = category;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }


}
