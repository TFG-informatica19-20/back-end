package com.microservices.tournamentx.userprofile.services;

import com.microservices.tournamentx.userprofile.domain.User;
import reactor.core.publisher.Mono;

public interface CRUDUser {

    Mono<User> getUser(Long id);

    Mono<User> createUser(User user);

    Mono<User> updateUser(User user);

    void deleteUser(Long id);
}
