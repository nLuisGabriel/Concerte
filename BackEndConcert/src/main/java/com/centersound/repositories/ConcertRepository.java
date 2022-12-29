package com.centersound.repositories;

import com.centersound.entities.Concert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
    @Query(value = "select Distinct c.* from concerts c inner join concert_artist ac on c.id = ac.concert_id\n" +
            "where ac.artist_id = :artistID", nativeQuery = true)
    List<Concert> concertsByArtistId(@Param("artistID") Long artistID);
}