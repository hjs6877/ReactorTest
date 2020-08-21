package com.itvillage;

import reactor.core.publisher.Flux;

public class SubscribeMethodExample01 {
    public static void main(String[] args) {
        Flux<Integer> seq = Flux.range(1, 3);
        seq.subscribe(i -> System.out.println(i));
    }
}
