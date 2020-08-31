package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Map;

public class Chapter10CollectMapTest {
    @Test
    public void collectMapTest() {
        Flux<String> flux = Flux
                .just("elephant", "koala", "eagle", "kangaroo");

        Mono<Map<String, String>> mono = flux.collectMap(a -> a.substring(0,2));

        StepVerifier.create(mono)
                .expectNextMatches(map -> map.size() == 4 &&
                        map.get("el").equals("elephant") &&
                        map.get("ko").equals("koala") &&
                        map.get("ea").equals("eagle") &&
                        map.get("ka").equals("kangaroo"))
                .verifyComplete();
    }
}
