package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Chapter10CreateDataTest {
    @Test
    public void createRangeTest() {
        Flux<Integer> flux = Flux.range(1, 5);

        StepVerifier.create(flux)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectNext(5)
                .verifyComplete();
    }

    @Test
    public void createInterval() {
        Flux<Long> flux =
                Flux.interval(Duration.ofSeconds(1))
                    .take(5);


        StepVerifier.create(flux)
                .expectNext(0L)
                .expectNext(1L)
                .expectNext(2L)
                .expectNext(3L)
                .expectNext(4L)
                .verifyComplete();

    }
}
