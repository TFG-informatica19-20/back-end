package com.microservices.tournamentx.battleshipqueue.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document
@Getter
@EqualsAndHashCode
@NoArgsConstructor
public class BattleshipLobby {

    public static final int expectedPlayers = 2;

    @Id
    private String id;

    private Set<String> players = new HashSet<>(expectedPlayers);

    @Setter
    private String gameId;

    @Setter
    private Status status = Status.INITIALIZING;

    private LocalDateTime init = LocalDateTime.now();

    @Setter
    private LocalDateTime end;
}
