package com.example.battleship.controllers;

import com.example.battleship.domain.Game;
import com.example.battleship.domain.recievedData.LobbyInfo;
import com.example.battleship.domain.recievedData.PlayerShipsInfo;
import com.example.battleship.domain.recievedData.TurnInfo;
import com.example.battleship.services.BattleshipGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class BattleshipGameController {

    private BattleshipGame battleshipGameService;

    @Autowired
    BattleshipGameController(BattleshipGame bg){
        this.battleshipGameService = bg;
    }

    @PostMapping("/games")
    public Mono<Game> createGame(@Valid LobbyInfo info){
        return this.battleshipGameService.createGame(info);
    }

    @GetMapping("/games/{id}")
    public Mono<Game> getGame(@PathVariable("id") String id){
        return this.battleshipGameService.getGame(id);
    }

    @PostMapping("/games/{id}")
    public Mono<Game> playTurn(@PathVariable("id") String id, @Valid TurnInfo turnInfo){
        return this.battleshipGameService.playTurn(id, turnInfo);
    }

    @PostMapping("/games/{id}/players/{user}")
    public Mono<Game> setPlayerShips(@PathVariable("id") String id, @PathVariable("user") String user, @Valid PlayerShipsInfo ships){
        return this.battleshipGameService.setShips(id, user, ships);
    }
}
