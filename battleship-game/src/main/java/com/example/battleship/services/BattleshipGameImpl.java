package com.example.battleship.services;

import com.example.battleship.domain.Game;
import com.example.battleship.domain.Player;
import com.example.battleship.domain.recievedData.LobbyInfo;
import com.example.battleship.domain.recievedData.PlayerShipsInfo;
import com.example.battleship.domain.recievedData.TurnInfo;
import com.example.battleship.repository.BattleshipGameCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class BattleshipGameImpl implements BattleshipGame {

    BattleshipGameCrudRepository battleshipGameCrudRepository;

    @Autowired
    BattleshipGameImpl(BattleshipGameCrudRepository battleshipGameCrudRepository){
        this.battleshipGameCrudRepository = battleshipGameCrudRepository;
    }

    @Override
    public Mono<Game> createGame(LobbyInfo info) {
        List<Player> players = new ArrayList<>();
        for(String s: info.getPlayers()){
            players.add(new Player(s));
        }
        return this.battleshipGameCrudRepository.save(new Game(info.getLobbyID(), players));
    }

    @Override
    public Mono<Game> getGame(String id) {
        return this.battleshipGameCrudRepository.findById(id);
    }

    @Override
    public Mono<Game> setShips(String id, String user, PlayerShipsInfo shipsInfo) {
        this.battleshipGameCrudRepository.findById(id)
                .subscribe(game -> {
                    if(game.isPlayerTurn(user)) {
                        this.computeTurn(game);
                    } else {
                        throw new RuntimeException(); //invalid turn exception
                    }
                });
        return null;
    }

    @Override
    public Mono<Game> playTurn(String id, TurnInfo turnInfo) {
        this.battleshipGameCrudRepository.findById(id)
                .subscribe(game -> {
                    //do things
                });
        return null;
    }


    private Game computeTurn(Game game){
        return null;
    }
}
