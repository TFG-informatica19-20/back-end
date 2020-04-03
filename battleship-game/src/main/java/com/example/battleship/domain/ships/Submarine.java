package com.example.battleship.domain.ships;

import java.util.Collection;

public class Submarine extends Ship {
    private static final Integer SIZE=3;

    public Submarine(Collection<Integer> positions) {
        super(positions);
    }

    @Override
    public boolean hasSunk() {
        return hitPositions.size() == SIZE;
    }
}
