package com.microservices.tournamentx.battleshipqueue.receivedData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JoinQueueRequest {
    private String userId;
}
