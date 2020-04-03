package com.example.battleship.domain.recievedData;

import java.util.List;

public class LobbyInfo {
    private final String lobbyID;
    private final List<String> players;

    public LobbyInfo(String lobbyID, List<String> players) {
        this.lobbyID = lobbyID;
        this.players = players;
    }

    public String getLobbyID() {
        return lobbyID;
    }

    public List<String> getPlayers() {
        return players;
    }
}
