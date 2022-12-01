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
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToOne(cascade = CascadeType.MERGE )
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private MusicalCategory category;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime date;

    @Column(name = "PRICE", scale = 2, nullable = false)
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name="concert_artist",
            joinColumns =  @JoinColumn(name="concert_id"),
            inverseJoinColumns = @JoinColumn(name="artist_id")
    )
    private Set<Artist> artists;

    @OneToMany(mappedBy = "concert")
    private Set<Order> orders;


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
