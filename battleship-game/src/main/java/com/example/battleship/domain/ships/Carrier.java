package com.example.battleship.domain.ships;

import java.util.Collection;

public class Carrier extends Ship{

    private static final Integer SIZE=5;

    public Carrier(Collection<Integer> positions) {
        super(positions);
    }

    @Override
    public boolean hasSunk() {
        return hitPositions.size() == SIZE;
    }
}
