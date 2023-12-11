package com.menghuan.flux;

import reactor.core.publisher.Flux;

public class FluxTest {

    public static void main(String[] args) {
        // 创建一个 Flux
        Flux<String> flux = Flux.create(emitter -> {
            // 在这里定义你的数据生成逻辑
            emitter.next("One");
            emitter.next("Two");
            emitter.next("Three");
            // 表示数据生成完成
            emitter.complete();
        });

        // 订阅 Flux 并处理元素
        flux.subscribe(
            // 处理 next 事件的回调
            System.out::println,
            // 处理 error 事件的回调
            Throwable::printStackTrace,
            // 处理 complete 事件的回调
            () -> System.out.println("Complete"));
    }

}
