package com.example.battleship.domain;

import com.example.battleship.domain.enums.ShipTypes;
import com.example.battleship.domain.exceptions.InvalidShipTypeException;
import com.example.battleship.domain.ships.*;

import java.util.Collection;

public class ShipFactory {

    public static Ship ShipType(ShipTypes types, Collection<Integer> position){
        switch (types){
            case CARRIER:
                return new Carrier(position);
            case BATTLESHIP:
                return new Battleship(position);
            case DESTROYER:
                return new Destroyer(position);
            case SUBMARINE:
                return new Submarine(position);
            case PATROL:
                return new PatrolBoat(position);
        }
        throw new InvalidShipTypeException();
    }
}