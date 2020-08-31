package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Chapter10AnyTest {
    @Test
    public void anyTest() {
        Flux<String> flux = Flux
                .just("elephant", "koala", "eagle", "kangaroo");

        Mono<Boolean> hasTMono = flux.any(animal -> animal.contains("t"));
        StepVerifier.create(hasTMono)
                .expectNext(true)
                .verifyComplete();

        Mono<Boolean> hasZMono = flux.any(animal -> animal.contains("z"));
        StepVerifier.create(hasZMono)
                .expectNext(false)
                .verifyComplete();
    }
}
