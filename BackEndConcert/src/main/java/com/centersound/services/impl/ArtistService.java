package com.centersound.services.impl;

import com.centersound.dtos.ArtistDto;
import com.centersound.repositories.ArtistRepository;
import com.centersound.services.ArtistServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ArtistService implements ArtistServiceInterface {

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ArtistDto> getAll() {
        return artistRepository.findAll().stream()
                .map(currentArtist ->{
                    ArtistDto artistDto = modelMapper.map(currentArtist, ArtistDto.class);
                    return artistDto;
                }).collect(Collectors.toList());
    }

    @Override
    public List<ArtistDto> getAllByConcertId(Long concertId) {
        List<ArtistDto> artistDtos = new ArrayList<>();
        artistDtos =  this.artistRepository.artistsByConcertId(concertId).stream().map((currentArtist ->{
            ArtistDto artistDto = modelMapper.map(currentArtist, ArtistDto.class);
            return artistDto;
        })).collect(Collectors.toList());
        return artistDtos;
    }
}
