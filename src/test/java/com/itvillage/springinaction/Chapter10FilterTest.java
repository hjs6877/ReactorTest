package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Chapter10FilterTest {
    @Test
    public void filterTest() {
        Flux<String> flux = Flux
                .just("Yellostone", "Yosemiite", "Grand Canyon", "Zion", "Grand Teton")
                .filter(np -> !np.contains(" "));

        StepVerifier.create(flux)
                .expectNext("Yellostone", "Yosemiite", "Zion")
                .verifyComplete();

    }
}
