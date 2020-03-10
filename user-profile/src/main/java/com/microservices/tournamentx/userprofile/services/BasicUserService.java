package com.microservices.tournamentx.userprofile.services;

import com.microservices.tournamentx.userprofile.domain.User;
import com.microservices.tournamentx.userprofile.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BasicUserService implements CRUDUser {

    private UserRepository userRepository;

    public BasicUserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Mono<User> getUser(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Mono<User> createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Mono<User> updateUser(User user) {
        return this.userRepository.existsById(user.getId())
                .flatMap(cond -> {
                    if (cond) {
                        return this.userRepository.save(user);
                    } else {
                        return Mono.empty();
                    }
                });
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    private Mono<Boolean> existsUser(User user){
        return this.userRepository.existsById(user.getId());
    }
}
