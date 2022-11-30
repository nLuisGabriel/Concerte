package com.centersound.controllers;

import com.centersound.dtos.ConcertDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/concerts")
public interface ConcertControllerInterface {
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ConcertDto> findAllConcerts();
}
