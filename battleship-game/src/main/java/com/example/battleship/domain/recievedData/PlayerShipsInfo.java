package com.example.battleship.domain.recievedData;

import com.example.battleship.domain.ships.*;

import java.util.List;

public class PlayerShipsInfo {

    private String gameID;
    private Carrier carrier;
    private List<Battleship> battleships;
    private List<Destroyer> destroyers;
    private List<Submarine> submarines;
    private List<PatrolBoat> boats;

    public String getGameID() {
        return gameID;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public List<Battleship> getBattleships() {
        return battleships;
    }

    public List<Destroyer> getDestroyers() {
        return destroyers;
    }

    public List<Submarine> getSubmarines() {
        return submarines;
    }

    public List<PatrolBoat> getBoats() {
        return boats;
    }
}
