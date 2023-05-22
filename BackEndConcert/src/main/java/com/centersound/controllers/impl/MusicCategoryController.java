package com.centersound.controllers.impl;

import com.centersound.controllers.MusicCategoryControllerInterface;
import com.centersound.entities.MusicalCategory;
import com.centersound.services.MusicCategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicCategoryController implements MusicCategoryControllerInterface {

    @Autowired
    MusicCategoryServiceInterface musicCategoryServiceInterface;

    @Override
    public List<MusicalCategory> findAllMusicalCategory() {
        return musicCategoryServiceInterface.findALlMusicCategory();
    }
}
