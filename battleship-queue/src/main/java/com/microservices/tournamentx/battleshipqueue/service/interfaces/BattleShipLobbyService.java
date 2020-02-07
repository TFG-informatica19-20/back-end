package com.microservices.tournamentx.battleshipqueue.service.interfaces;

import com.microservices.tournamentx.battleshipqueue.domain.BattleshipLobby;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BattleShipLobbyService {

    BattleshipLobby createGameLobby();

    Mono<BattleshipLobby> joinGameLobby(BattleshipLobby gameLobby, String userId);

    Flux<BattleshipLobby> getAllLobbies();

    Mono<BattleshipLobby> getLobbyById(String id);

}
