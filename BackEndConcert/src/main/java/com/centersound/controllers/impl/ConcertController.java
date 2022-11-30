package com.centersound.controllers.impl;

import com.centersound.controllers.ConcertControllerInterface;
import com.centersound.dtos.ConcertDto;
import com.centersound.services.ConcertServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConcertController implements ConcertControllerInterface {
    @Autowired
    ConcertServiceInterface concertServiceInterface;

    @Override
    public List<ConcertDto> findAllConcerts() {
        return concertServiceInterface.findAllConcerts();
    }
}
