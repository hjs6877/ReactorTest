package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Chapter10DistinctTest {
    @Test
    public void distinctTest() {
        Flux<String> flux = Flux
                .just("dog", "cat", "bird", "dog", "bird", "anteater")
                .distinct();

        StepVerifier.create(flux)
                .expectNext("dog", "cat", "bird", "anteater")
                .verifyComplete();
    }
}
