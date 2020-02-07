package com.microservices.tournamentx.battleshipqueue.service;


import com.microservices.tournamentx.battleshipqueue.domain.BattleshipLobby;
import com.microservices.tournamentx.battleshipqueue.sentData.StartGameMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.MessageBuilder;


@Configuration
@EnableBinding(Source.class)
public class StartGameMessageSender {

    @Autowired
    Source source;

    public void sendMessage(BattleshipLobby lobby){
        StartGameMessage message = new StartGameMessage(lobby.getPlayers(), lobby.getId());
        source.output()
                .send(MessageBuilder.withPayload(message)
                .setHeader("myheader", "myHeaderValue").build());
    }
}
