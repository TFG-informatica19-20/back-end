/*
package com.example.battleship.controllers;

import com.example.battleship.domain.Game;
import com.example.battleship.services.BattleshipSpectator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BattleshipSpectatorController {

    private BattleshipSpectator battleshipGameSpectator;

    @Autowired
    BattleshipSpectatorController(BattleshipSpectator bs){
        this.battleshipGameSpectator = bs;
    }

    @PostMapping("/games/{id}")
    public Mono<Game> createGame(@PathVariable String id){
        return this.battleshipGameSpectator.getGameStatus(id);
    }
}
*/