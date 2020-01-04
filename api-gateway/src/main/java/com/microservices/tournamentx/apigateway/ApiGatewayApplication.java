package com.microservices.tournamentx.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("queue-service", r -> r.path("/lobbies")
                        .uri("lb://battleship-queue"))
                .route("queue-stats-service", r -> r.path("/queues")
                        .uri("lb://battleship-queue-stats"))
                .route("game-service", r -> r.path("/games")
                        .uri("lb://battleship-game"))
                .build();
    }

}
