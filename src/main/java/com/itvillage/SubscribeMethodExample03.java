package com.itvillage;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class SubscribeMethodExample03 {
    public static void main(String[] args) throws InterruptedException {
        Flux<Integer> seq = Flux.range(1, 4);

        seq.subscribe(
                i -> System.out.println(i),
                error -> System.out.println("#error: " + error),
                () -> System.out.println("Done"),
                subscription -> subscription.request(10)
        );
    }
}
