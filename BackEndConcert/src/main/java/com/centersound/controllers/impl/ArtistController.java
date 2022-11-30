package com.centersound.controllers.impl;


import com.centersound.controllers.ArtistControllerInterface;
import com.centersound.dtos.ArtistDto;
import com.centersound.services.ArtistServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ArtistController implements ArtistControllerInterface {

    @Autowired
    ArtistServiceInterface artistServiceInterface;

    @Override
    public List<ArtistDto> findAllArtists() {
        return artistServiceInterface.getAll();
    }
}
