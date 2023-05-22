package com.centersound.services;

import com.centersound.dtos.ConcertDto;
import com.centersound.entities.Concert;

import java.util.List;

public interface ConcertServiceInterface {
    List<ConcertDto> findAllConcerts();
    List<ConcertDto> findAllByArtist(Long artistId);
}
