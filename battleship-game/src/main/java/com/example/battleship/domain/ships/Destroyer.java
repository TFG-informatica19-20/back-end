package com.example.battleship.domain.ships;

import java.util.Collection;

public class Destroyer extends Ship{
    private static final Integer SIZE=3;

    public Destroyer(Collection<Integer> positions) {
        super(positions);
    }

    @Override
    public boolean hasSunk() {
        return hitPositions.size() == SIZE;
    }
}
