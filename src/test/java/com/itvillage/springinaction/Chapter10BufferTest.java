package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class Chapter10BufferTest {
    @Test
    public void bufferTest() {
        Flux<String> flux = Flux
                .just("apple", "orange", "banana", "kiwi", "strawberry");

        Flux<List<String>> bufferedFlux = flux.buffer(3);

        StepVerifier.create(bufferedFlux)
                .expectNext(Arrays.asList("apple", "orange", "banana"))
                .expectNext(Arrays.asList("kiwi", "strawberry"))
                .verifyComplete();
    }

    @Test
    public void bufferTest2() throws InterruptedException {
        Flux
                .just("apple", "orange", "banana", "kiwi", "strawberry")
                .buffer(3)
                .flatMap(f ->
                        Flux.fromIterable(f)
                            .map(y -> y.toUpperCase())
                            .subscribeOn(Schedulers.parallel())
                            .log()
                ).subscribe();

        Thread.sleep(100L);
    }
}
