package com.microservices.tournamentx.battleshipqueue.repository;

import com.microservices.tournamentx.battleshipqueue.domain.BattleshipLobby;
import com.microservices.tournamentx.battleshipqueue.domain.Status;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BattleshipLobbyRepository extends ReactiveMongoRepository<BattleshipLobby, String> {
    Mono<BattleshipLobby> findFirstByStatusOrderByInitTime(Status status);
}
