package com.menghuan.flux;

import java.time.Duration;

import org.junit.Test;

import reactor.core.publisher.Flux;

public class FluxExample {

    /**
     * 验证 Flux 的异步性
     */
    @Test
    public void checkAsync() {
        Flux<Integer> numbers = Flux.range(1, 10);

        numbers.delayElements(Duration.ofSeconds(1)).subscribe(System.out::println);

        // 阻塞主线程，以便我们能够观察到数据流
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 求和
     */
    @Test
    public void fluxSum() {
        Flux.range(1, 10).map(i -> i * 2).filter(i -> i > 10).flatMap(i -> Flux.range(i, 2)).take(5)
            .reduce(0, Integer::sum).subscribe(System.out::println);
    }

}