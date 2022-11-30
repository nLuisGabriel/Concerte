package com.centersound.services;

import com.centersound.dtos.ConcertDto;

import java.util.List;

public interface ConcertServiceInterface {
    List<ConcertDto> findAllConcerts();
    List<ConcertDto> findAllByArtist();
}
