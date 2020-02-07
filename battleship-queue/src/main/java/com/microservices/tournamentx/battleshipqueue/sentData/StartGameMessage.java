package com.microservices.tournamentx.battleshipqueue.sentData;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
public class StartGameMessage {

    private final Set<String> players;
    private final String lobbyId;

    public StartGameMessage(Set<String> players, String lobbyId) {
        this.players = players;
        this.lobbyId = lobbyId;
    }
}
