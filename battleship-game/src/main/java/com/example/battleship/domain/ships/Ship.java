package com.example.battleship.domain.ships;

import com.example.battleship.domain.Sinkable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Ship implements Sinkable {

    private final Set<Integer> positions;
    Set<Integer> hitPositions;

    Ship(Collection<Integer> positions) {
        this.positions = new HashSet<>(positions);
        this.hitPositions = new HashSet<>();
    }

    boolean computeHit(Integer pos){
        this.hitPositions.add(pos);
        return this.hasSunk();
    }
}
