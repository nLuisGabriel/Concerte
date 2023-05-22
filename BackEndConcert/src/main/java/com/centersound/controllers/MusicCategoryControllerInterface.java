package com.centersound.controllers;


import com.centersound.entities.MusicalCategory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "musicCategory")
public interface MusicCategoryControllerInterface {
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MusicalCategory> findAllMusicalCategory();
}
