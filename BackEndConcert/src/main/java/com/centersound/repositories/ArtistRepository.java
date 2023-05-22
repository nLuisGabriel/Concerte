package com.centersound.repositories;

import com.centersound.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query(value = "select a.* from artists a inner join concert_artist  ca on a.id =  ca.artist_id\n" +
                    "where ca.concert_id = :concertId", nativeQuery = true
    )
    List<Artist> artistsByConcertId(@Param("concertId") Long concertId);
}