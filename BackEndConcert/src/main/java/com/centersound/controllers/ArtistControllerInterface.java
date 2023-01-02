package com.centersound.controllers;

import com.centersound.dtos.ArtistDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "artists")
public interface ArtistControllerInterface {
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArtistDto> findAllArtists();

    @GetMapping(value = "/getAllByConcertId/{concertId}")
    List<ArtistDto> findAllArtistByConcertId(@PathVariable Long concertId);
}
