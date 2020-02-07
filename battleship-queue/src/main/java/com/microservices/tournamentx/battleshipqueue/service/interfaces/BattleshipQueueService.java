package com.microservices.tournamentx.battleshipqueue.service.interfaces;

import com.microservices.tournamentx.battleshipqueue.domain.BattleshipLobby;

public interface BattleshipQueueService {
    void updateAverageWaitingTime(BattleshipLobby gameLobby);
}
