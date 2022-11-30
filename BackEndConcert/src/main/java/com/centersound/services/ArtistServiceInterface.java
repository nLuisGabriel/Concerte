package com.centersound.services;

import com.centersound.dtos.ArtistDto;

import java.util.List;

public interface ArtistServiceInterface {
    List<ArtistDto> getAll();
}
