package com.itvillage.springinaction;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Chapter10Create {
    @Test
    public void createFluxJustTest() {
        Flux<String> flux = Flux.just("Apple", "Orange", "Grape", "Banana", "Strawberry");
        StepVerifier.create(flux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    @Test
    public void createFluxFromArrayTest() {
        String[] fruits = {"Apple", "Orange", "Grape", "Banana", "Strawberry"};

        Flux<String> flux = Flux.fromArray(fruits);

        StepVerifier.create(flux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    @Test
    public void createFluxFromIterable() {
        List<String> fruits = Arrays.asList("Apple", "Orange", "Grape", "Banana", "Strawberry");

        Flux<String> flux = Flux.fromIterable(fruits);

        StepVerifier.create(flux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }

    @Test
    public void createFluxFromStreamTest() {
        Stream<String> fruitStream = Stream.of("Apple", "Orange", "Grape", "Banana", "Strawberry");

        Flux<String> flux = Flux.fromStream(fruitStream);

        StepVerifier.create(flux)
                .expectNext("Apple")
                .expectNext("Orange")
                .expectNext("Grape")
                .expectNext("Banana")
                .expectNext("Strawberry")
                .verifyComplete();
    }
}
