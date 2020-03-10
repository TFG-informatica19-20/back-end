package com.microservices.tournamentx.userprofile.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.neo4j.springframework.data.core.schema.GeneratedValue;
import org.neo4j.springframework.data.core.schema.Node;
import org.neo4j.springframework.data.core.schema.Relationship;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.Set;

@Node
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Max(32)
    @Min(4)
    private String alias;

    @Max(256)
    private String description;

    private Long totalGames;
    private Long totalWins;
    private Long totalLoses;

    @CreatedDate
    private LocalDateTime createdDate;

    private LocalDateTime lastLoggedIn;

    @Relationship
    private Set<User> friends;

    @Relationship
    private Set<User> blocked;
}
