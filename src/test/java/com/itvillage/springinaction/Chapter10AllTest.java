package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Chapter10AllTest {
    @Test
    public void allTest() {
        Flux<String> flux = Flux
                .just("elephant", "koala", "eagle", "kangaroo");
        Mono<Boolean> hasAFlux = flux
                .all(animal -> animal.contains("a"));

        StepVerifier.create(hasAFlux)
                .expectNext(true)
                .verifyComplete();

        Mono<Boolean> hasKFlux = flux
                .all(animal -> animal.contains("k"));

        StepVerifier.create(hasKFlux)
                .expectNext(false)
                .verifyComplete();
    }
}
