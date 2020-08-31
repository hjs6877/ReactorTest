package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;


public class Chapter10FlatMapTest {
    @Test
    public void flatMapTest() {
        Flux<String> playerFlux = Flux
                .just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
                .flatMap(player -> Mono.just(player)
                    .map(p -> {
                        String[] splited = p.split("\\s");
                        return splited[0];
                    })
                    .subscribeOn(Schedulers.parallel())
                );

        List<String> players = Arrays.asList("Michael", "Scottie", "Steve");

        StepVerifier.create(playerFlux)
                .expectNextMatches(p -> players.contains(p))
                .expectNextMatches(p -> players.contains(p))
                .expectNextMatches(p -> players.contains(p))
                .verifyComplete();
    }
}
