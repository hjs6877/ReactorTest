package com.itvillage;

import reactor.core.publisher.Flux;

public class HelloWorld {
    public static void main(String[] args) {
        Flux<String> seq = Flux.just("Hello", "World");
        seq.subscribe(data -> System.out.println(data));
    }
}
