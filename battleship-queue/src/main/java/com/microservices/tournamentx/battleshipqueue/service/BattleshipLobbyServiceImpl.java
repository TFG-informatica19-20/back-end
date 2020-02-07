package com.microservices.tournamentx.battleshipqueue.service;

import com.microservices.tournamentx.battleshipqueue.domain.BattleshipLobby;
import com.microservices.tournamentx.battleshipqueue.domain.Status;
import com.microservices.tournamentx.battleshipqueue.repository.BattleshipLobbyRepository;
import com.microservices.tournamentx.battleshipqueue.sentData.StartGameMessage;
import com.microservices.tournamentx.battleshipqueue.service.interfaces.BattleShipLobbyService;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class BattleshipLobbyServiceImpl implements BattleShipLobbyService {

    private final BattleshipLobbyRepository battleshipLobbyRepository;

    private final StartGameMessageSender sender;

    BattleshipLobbyServiceImpl(BattleshipLobbyRepository battleshipLobbyRepository,
                               StartGameMessageSender sender){
        this.battleshipLobbyRepository = battleshipLobbyRepository;
        this.sender = sender;
    }


    public BattleshipLobby createGameLobby() {
        return new BattleshipLobby();
    }

    public Mono<BattleshipLobby> joinGameLobby(BattleshipLobby gameLobby, String userId) {
        Set<String> players = gameLobby.getPlayers();
        players.add(userId);
        return this.updateGameLobby(gameLobby);
    }

    @Override
    public Flux<BattleshipLobby> getAllLobbies() {
        return this.battleshipLobbyRepository.findAll();
    }

    @Override
    public Mono<BattleshipLobby> getLobbyById(String id) {
        return this.battleshipLobbyRepository.findById(id);
    }

    private Mono<BattleshipLobby> updateGameLobby(BattleshipLobby gameLobby) {
        if(gameLobby.getPlayers().size() == BattleshipLobby.expectedPlayers){
            this.updateStatus(gameLobby);
            sender.sendMessage(gameLobby);
        }
        return battleshipLobbyRepository.save(gameLobby);
    }

    private void updateStatus(BattleshipLobby gameLobby) {
        gameLobby.setStatus(Status.nextStatus(gameLobby.getStatus()));
    }
}
