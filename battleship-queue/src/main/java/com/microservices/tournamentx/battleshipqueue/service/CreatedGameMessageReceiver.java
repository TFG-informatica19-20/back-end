/*
package com.microservices.tournamentx.battleshipqueue.service;

import com.microservices.tournamentx.battleshipqueue.receivedData.CreatedGameMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(Sink.class)
public class CreatedGameMessageReceiver {

        @Autowired
        Sink source;

        public void receiveMessage(){
            source.input().subscribe(message -> {
                CreatedGameMessage gameInfo = (CreatedGameMessage) message.getPayload();
            });
        }
    }
}
*/