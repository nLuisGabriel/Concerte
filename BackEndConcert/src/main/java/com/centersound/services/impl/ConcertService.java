package com.centersound.services.impl;

import com.centersound.dtos.ConcertDto;
import com.centersound.dtos.LocationDto;
import com.centersound.dtos.MusicalCategoryDto;
import com.centersound.repositories.ConcertRepository;
import com.centersound.services.ConcertServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConcertService implements ConcertServiceInterface {
    @Autowired
    ConcertRepository concertRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ConcertDto> findAllConcerts() {
        List<ConcertDto> concerts = concertRepository.findAll().stream()
                .map(currentConcert ->{
                    LocationDto locationDto = modelMapper.map(currentConcert.getLocation(), LocationDto.class);
                    MusicalCategoryDto musicalCategoryDto = modelMapper.map(currentConcert.getCategory(), MusicalCategoryDto.class);
                    ConcertDto concertDto = modelMapper.map(currentConcert, ConcertDto.class);
                    concertDto.setMusicalCategoryDto(musicalCategoryDto);
                    concertDto.setLocationDto(locationDto);
                   return concertDto;
                }).collect(Collectors.toList());
        return concerts;
    }

    @Override
    public List<ConcertDto> findAllByArtist() {
        return null;
    }
}
