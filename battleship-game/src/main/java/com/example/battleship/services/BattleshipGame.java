package com.example.battleship.services;

import com.example.battleship.domain.Game;
import com.example.battleship.domain.recievedData.LobbyInfo;
import com.example.battleship.domain.recievedData.PlayerShipsInfo;
import com.example.battleship.domain.recievedData.TurnInfo;
import reactor.core.publisher.Mono;

public interface BattleshipGame {
    Mono<Game> createGame(LobbyInfo info);
    Mono<Game> getGame(String id);
    Mono<Game> setShips(String id, String user, PlayerShipsInfo shipsInfo);
    Mono<Game> playTurn(String id, TurnInfo turnInfo);

}
