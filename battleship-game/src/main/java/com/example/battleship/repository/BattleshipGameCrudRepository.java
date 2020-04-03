package com.example.battleship.repository;

import com.example.battleship.domain.Game;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BattleshipGameCrudRepository extends ReactiveCrudRepository<Game, String> {

}
