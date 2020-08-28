package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Chapter10SkipTest {
    @Test
    public void skipTest() {
        Flux<String> skipFlux =
                Flux.just("one", "two", "three", "four", "five")
                    .skip(2);

        StepVerifier.create(skipFlux)
                .expectNext("three")
                .expectNext("four")
                .expectNext("five")
                .verifyComplete();

    }

    @Test
    public void skipTest2() {
        Flux<String> skipFlux = Flux
                .just("one", "two", "three", "four", "five")
                .delayElements(Duration.ofSeconds(1))
                .skip(Duration.ofSeconds(3));

        StepVerifier.create(skipFlux)
                .expectNext("three", "four", "five")
                .verifyComplete();


    }
}
