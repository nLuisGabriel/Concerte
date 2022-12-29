package com.centersound.services.impl;

import com.centersound.dtos.MusicalCategoryDto;
import com.centersound.entities.MusicalCategory;
import com.centersound.repositories.MusicalCategoryRepository;
import com.centersound.services.MusicCategoryServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicCategoryService implements MusicCategoryServiceInterface {

    @Autowired
    MusicalCategoryRepository musicalCategoryRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<MusicalCategory> findALlMusicCategory() {
        return musicalCategoryRepository.findAll().stream()
                .map(currentCategory ->{
                    MusicalCategoryDto musicalCategoryDto =
                            modelMapper.map(currentCategory, MusicalCategoryDto.class);
                    return currentCategory;
                }).collect(Collectors.toList());
    }
}
