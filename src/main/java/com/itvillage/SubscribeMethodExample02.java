package com.itvillage;

import reactor.core.publisher.Flux;

public class SubscribeMethodExample02 {
    public static void main(String[] args) {
        Flux.range(1, 4)
                .map(i -> {
                    if(i <= 3)
                        return i;
                    throw new RuntimeException("Go to 4");
                })
                .subscribe(
                        i -> System.out.println(i),
                        error -> System.out.println("#error: " + error));
    }
}
