package com.microservices.tournamentx.userprofile.repository;

import com.microservices.tournamentx.userprofile.domain.User;
import org.neo4j.springframework.data.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveNeo4jRepository<User, Long> {
}
