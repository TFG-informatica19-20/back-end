package com.example.battleship.domain.ships;

import java.util.Collection;

public class Battleship extends Ship {
    private static final Integer SIZE=4;

    public Battleship(Collection<Integer> positions) {
        super(positions);
    }

    @Override
    public boolean hasSunk() {
        return hitPositions.size() == SIZE;
    }
}
