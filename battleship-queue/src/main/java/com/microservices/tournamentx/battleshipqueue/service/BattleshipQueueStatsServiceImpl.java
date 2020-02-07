package com.microservices.tournamentx.battleshipqueue.service;

import com.microservices.tournamentx.battleshipqueue.domain.BattleshipLobby;
import com.microservices.tournamentx.battleshipqueue.domain.QueueStats;
import com.microservices.tournamentx.battleshipqueue.repository.BattleshipQueueStatsRepository;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
public class BattleshipQueueStatsServiceImpl {

    private final QueueStats stats;


    public BattleshipQueueStatsServiceImpl(BattleshipQueueStatsRepository battleshipQueueStatsRepository) {
        this.stats = battleshipQueueStatsRepository.findById("1").block();
    }


    private Long getWaitingTime(BattleshipLobby gameLobby) {
        return ChronoUnit.SECONDS.between(gameLobby.getInit(), gameLobby.getEnd());
    }

    public void updateAverageWaitingTime(BattleshipLobby gameLobby) {
        double lobbies = stats.getTotalLobbies();
       stats.setTotalLobbies(++lobbies);
        double averageWaitingTime = (stats.getAverageWaitingTime() + getWaitingTime(gameLobby)) / lobbies;
        stats.setAverageWaitingTime(averageWaitingTime);
    }
}
