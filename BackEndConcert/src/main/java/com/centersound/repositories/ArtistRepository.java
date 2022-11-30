package com.centersound.repositories;

import com.centersound.entities.Artist;
import com.centersound.entities.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}