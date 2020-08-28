package com.itvillage.springinaction;

import lombok.Data;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Chapter10MapTest {
    @Test
    public void map() {
        Flux<String> playerFlux = Flux
                .just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
                .map(n -> {
                    String[] split = n.split("\\s");
                    return split[0];
                });

        StepVerifier.create(playerFlux)
                .expectNext("Michael")
                .expectNext("Scottie")
                .expectNext("Steve")
                .verifyComplete();
    }
}
