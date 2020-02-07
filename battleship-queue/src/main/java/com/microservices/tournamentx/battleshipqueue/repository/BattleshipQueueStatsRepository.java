package com.microservices.tournamentx.battleshipqueue.repository;

import com.microservices.tournamentx.battleshipqueue.domain.QueueStats;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BattleshipQueueStatsRepository extends ReactiveMongoRepository<QueueStats, String> {
}
