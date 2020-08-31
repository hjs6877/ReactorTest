package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

public class Chapter10CollectListTest {
    @Test
    public void collectListTest() {
        Mono<List<String>> fruits =
                Flux.just("apple", "orange", "banana", "kiwi", "strawberry")
                .collectList();

        StepVerifier.create(fruits)
                .expectNext(Arrays.asList("apple", "orange", "banana", "kiwi", "strawberry"))
                .verifyComplete();
    }
}
