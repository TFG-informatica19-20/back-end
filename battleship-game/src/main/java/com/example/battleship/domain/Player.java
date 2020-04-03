package com.example.battleship.domain;

import com.example.battleship.domain.enums.BoxStatus;
import com.example.battleship.domain.enums.ShipTypes;
import com.example.battleship.domain.ships.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {
    private final String id;
    private List<BoxStatus> board;
    private Map<ShipTypes, List<Ship>> ships;

    public Player(String id){
        this.id = id;
        this.board = new ArrayList<>(100);
    }


    public String getId() {
        return id;
    }

    public List<BoxStatus> getBoard() {
        return board;
    }

    public void setBoard(List<BoxStatus> board) {
        this.board = board;
    }

    public void setShips(Map<ShipTypes, List<Ship>> ships) {
        this.ships = ships;
    }

    public List<Ship> getAllShips(){
        List<Ship> result = new ArrayList<>();
        ships.values().forEach(result::addAll);
        return result;
    }
}
