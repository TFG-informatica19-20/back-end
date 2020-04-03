package com.example.battleship.services;

import com.example.battleship.domain.Game;
import reactor.core.publisher.Mono;

public interface BattleshipSpectator {
    Mono<Game> getGameStatus(String id);
}
