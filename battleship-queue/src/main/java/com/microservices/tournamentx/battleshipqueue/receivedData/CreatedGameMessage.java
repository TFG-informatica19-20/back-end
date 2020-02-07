package com.microservices.tournamentx.battleshipqueue.receivedData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedGameMessage {
    String lobbyId;
    String gameId;
}
