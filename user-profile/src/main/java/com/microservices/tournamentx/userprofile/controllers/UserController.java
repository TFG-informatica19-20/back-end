package com.microservices.tournamentx.userprofile.controllers;

import com.microservices.tournamentx.userprofile.domain.User;
import com.microservices.tournamentx.userprofile.services.CRUDUser;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class UserController {

    private CRUDUser userService;

    public UserController(CRUDUser userService){
        this.userService = userService;
    }

    @GetMapping("/users/{id}")
    public Mono<User> getUser(@PathVariable("id") final Long id){
        return this.userService.getUser(id);
    }

    @PostMapping("/users")
    public Mono<User> createUser(@RequestBody @Valid User newUser){
        return this.userService.createUser(newUser);
    }

    @PostMapping("/users/{id}")
    public Mono<User> updateUser(@PathVariable("id")final Long id, @RequestBody @Valid User user){
        return this.userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") final Long id){
        this.userService.deleteUser(id);
    }
}
