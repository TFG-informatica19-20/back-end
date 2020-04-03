package com.example.battleship.domain;

import com.example.battleship.domain.enums.BoxStatus;

public class Turn {
    private final Integer num;
    private final String player;
    private final Integer pos;
    private final BoxStatus result;

    public Turn(Integer num, String player, Integer pos, BoxStatus result) {
        this.num = num;
        this.player = player;
        this.pos = pos;
        this.result = result;
    }
}
