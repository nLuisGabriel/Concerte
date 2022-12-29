package com.centersound.services.impl;

import com.centersound.dtos.ConcertDto;
import com.centersound.dtos.LocationDto;
import com.centersound.dtos.MusicalCategoryDto;
import com.centersound.entities.Concert;
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
        return this.concertListToConcertDtoList(concertRepository.findAll(), true);
    }

    @Override
    public List<ConcertDto> findAllByArtist(Long artistId) {
        return this.concertListToConcertDtoList(concertRepository.concertsByArtistId(artistId), false);
    }

    private List<ConcertDto> concertListToConcertDtoList(List<Concert> concertList, boolean allReferences){
        return concertList.stream().map(currentConcert->{
            LocationDto locationDto = modelMapper.map(currentConcert.getLocation(), LocationDto.class);
            MusicalCategoryDto musicalCategoryDto = modelMapper.map(currentConcert.getCategory(), MusicalCategoryDto.class);
            ConcertDto concertDto = modelMapper.map(currentConcert, ConcertDto.class);
            concertDto.setMusicalCategoryDto(allReferences ? musicalCategoryDto: null);
            concertDto.setLocationDto(allReferences ? locationDto : null);
            return concertDto;
        }).collect(Collectors.toList());
    }


}
