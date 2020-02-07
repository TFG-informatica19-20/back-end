package com.microservices.tournamentx.battleshipqueue.controller;

import com.microservices.tournamentx.battleshipqueue.domain.BattleshipLobby;
import com.microservices.tournamentx.battleshipqueue.receivedData.JoinQueueRequest;
import com.microservices.tournamentx.battleshipqueue.domain.Status;
import com.microservices.tournamentx.battleshipqueue.repository.BattleshipLobbyRepository;
import com.microservices.tournamentx.battleshipqueue.service.BattleshipLobbyServiceImpl;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class BattleshipLobbyController {

    private final BattleshipLobbyServiceImpl battleshipLobbyServiceImpl;

    private final BattleshipLobbyRepository battleshipLobbyRepository;

    public BattleshipLobbyController(BattleshipLobbyServiceImpl battleshipLobbyServiceImpl, BattleshipLobbyRepository battleshipLobbyRepository) {
        this.battleshipLobbyServiceImpl = battleshipLobbyServiceImpl;
        this.battleshipLobbyRepository = battleshipLobbyRepository;
    }

    @PostMapping(path="/lobbies", consumes = "application/json")
    public Mono<BattleshipLobby> joinOrCreate(@RequestBody @Valid JoinQueueRequest payload) {
        return battleshipLobbyRepository
                .findFirstByStatusOrderByInitTime(Status.INITIALIZING)
                .defaultIfEmpty(battleshipLobbyServiceImpl.createGameLobby())
                .flatMap(gameLobby -> battleshipLobbyServiceImpl.joinGameLobby(gameLobby, payload.getUserId()));
    }

    @GetMapping("/lobbies")
    public Flux<BattleshipLobby> getAllLobbies() {
        return battleshipLobbyRepository.findAll();
    }

    @GetMapping("/lobbies/{id}")
    public Mono<BattleshipLobby> getLobbyUpdates(@PathVariable("id") final String id){
        return battleshipLobbyRepository.findById(id);
    }
}
