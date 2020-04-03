package com.example.battleship.domain.ships;

import java.util.Collection;

public class PatrolBoat extends Ship {
    private static final Integer SIZE=2;

    public PatrolBoat(Collection<Integer> positions) {
        super(positions);
    }

    @Override
    public boolean hasSunk() {
        return hitPositions.size() == SIZE;
    }
}
