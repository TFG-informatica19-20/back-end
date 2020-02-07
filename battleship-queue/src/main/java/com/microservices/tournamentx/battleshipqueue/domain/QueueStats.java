package com.microservices.tournamentx.battleshipqueue.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class QueueStats {

    @Id
    private String id;

    private double averageWaitingTime = 0;

    private double totalLobbies = 0;
    private double availableLobbies = 0;
    private double canceledLobbies = 0;
    private double successfulLobbies = 0;
}
