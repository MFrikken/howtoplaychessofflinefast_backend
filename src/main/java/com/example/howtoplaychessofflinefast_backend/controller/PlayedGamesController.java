package com.example.howtoplaychessofflinefast_backend.controller;

import com.example.howtoplaychessofflinefast_backend.entity.PlayedGamesEntity;
import com.example.howtoplaychessofflinefast_backend.service.PlayedGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping(path = "/playedGames")
public class PlayedGamesController {

    private final PlayedGamesService playedGamesService;

    @Autowired
    public PlayedGamesController(PlayedGamesService playedGamesService) {
        this.playedGamesService = playedGamesService;
    }

    @GetMapping(path = "/getCount")
    public Integer getCount() {
        return playedGamesService.getCount();
    }

    @GetMapping(path = "/increaseCount")
    public Integer increaseCount() {
        return playedGamesService.increaseCount();
    }

    @GetMapping(path = "/getAll")
    public List<PlayedGamesEntity> getAll() {
        return playedGamesService.getAll();
    }
}
