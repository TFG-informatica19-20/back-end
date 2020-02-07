package com.microservices.tournamentx.battleshipqueue.controller;

import com.microservices.tournamentx.battleshipqueue.domain.QueueStats;
import com.microservices.tournamentx.battleshipqueue.repository.BattleshipQueueStatsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class BattleshipQueueStatsController {
    private final BattleshipQueueStatsRepository battleshipQueueStatsRepository;


    public BattleshipQueueStatsController(BattleshipQueueStatsRepository battleshipQueueStatsRepository) {
        this.battleshipQueueStatsRepository = battleshipQueueStatsRepository;
    }

    @GetMapping("/queues")
    public Flux<QueueStats> getAllLobbies() {
        return battleshipQueueStatsRepository.findAll();
    }

    @GetMapping("/queues/{id}")
    public Mono<QueueStats> getLobbyUpdates(@PathVariable("id") final String id){
        return battleshipQueueStatsRepository.findById(id);
    }
}
