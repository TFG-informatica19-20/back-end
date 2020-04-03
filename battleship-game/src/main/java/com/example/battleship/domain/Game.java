package com.example.battleship.domain;

import com.example.battleship.domain.enums.GameStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;
import java.util.stream.Collectors;

@Document
public class Game {
    private static final Integer NUM_CARRIERS = 1;
    private static final Integer NUM_BATTLESHIPS = 2;
    private static final Integer NUM_SUBMARINES = 3;
    private static final Integer NUM_DESTROYERS = 3;
    private static final Integer NUM_BOATS = 2;

    @Id
    private String id;
    private final String lobbyID;

    private GameStatus status;
    private String playerTurn;

    private String winner;
    private List<Player> players;


    private List<Turn> turns;


    private final Date created_at;
    private Date ended_at;

    public Game(String lobbyID, List<Player> players) {
        status = GameStatus.CREATING;
        this.lobbyID = lobbyID;
        created_at = new Date();
        this.players = players;

        this.playerTurn = this.players.get(0).getId();
        this.winner = null;
        this.turns = new ArrayList<>();
    }

    public boolean isPlayerTurn(String id) { return id.equals(this.playerTurn);}

    public void setWinner(String id){
        this.winner = id;
        this.ended_at = new Date();
    }

    public void addTurn(Turn turn){
        this.turns.add(turn);
    }

    /* Create custom collector to reach more elegant solution */
    public Player getPlayer(String id) {
        return players.parallelStream()
                .filter(player -> player.getId().equals(id))
                .collect(Collectors.toList())
                .get(0);
    }
}
