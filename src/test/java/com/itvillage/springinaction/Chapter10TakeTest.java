package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Chapter10TakeTest {
    @Test
    public void takeTest() {
        Flux<String> takeFlux = Flux
                .just("one", "two", "three", "four", "five")
                .take(3);

        StepVerifier.create(takeFlux)
                .expectNext("one", "two", "three")
                .verifyComplete();

    }

    @Test
    public void takeTest2() {
        Flux<String> takeFlux = Flux
                .just("one", "two", "three", "four", "five")
                .delayElements(Duration.ofSeconds(1))
                .take(Duration.ofMillis(2500));

        StepVerifier.create(takeFlux)
                .expectNext("one", "two")
                .verifyComplete();
    }
}
