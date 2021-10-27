package com.hanchan.MultiThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/**
 * @Author: menghuan
 * @Date: 2021/7/28 11:41
 */
public class ThreadMillion {

    public static void main(String[] args) throws InterruptedException {
        // 目前有需要处理1000w个数据
        List<String> list = new ArrayList<>();
        IntStream.range(0, 10000000).boxed()
                .forEach(i -> list.add(String.valueOf(i)));

        // 每次最大处理个数是10w个
        int maxHandle = 100000;

        // 计算出需要处理的总次数
        int handleTotal = (list.size() + maxHandle - 1) / maxHandle;
        System.out.println("需要处理的总次数 handleTotal :" + handleTotal);

        long start = System.currentTimeMillis();

        // 开启 （需处理总次数的）线程池
        ExecutorService executorService = Executors.newFixedThreadPool(handleTotal);
        // 用于使主线程等待所有线程都已结束（根据业务需求决定）
        CountDownLatch downLatch = new CountDownLatch(handleTotal);

        AtomicLong a = new AtomicLong(0);

        // 使用 Java8 进行分页开线程，处理数据
        IntStream.range(0, handleTotal)
                .boxed()
                .forEach(index -> {
                            // long start0 = System.currentTimeMillis();
                            executorService.submit(() -> {
                                list.stream().skip(index * maxHandle).limit(maxHandle).forEach(i -> {
                                    long result = Long.valueOf(i) % 2;
                                    a.addAndGet(result);
                                });
                                System.err.println("{第" + (index + 1) + "个线程}｜｜耗时：" + (System.currentTimeMillis() - start) + "ms,index=" + index * maxHandle);
                                // 用于使主线程等待所有线程都已结束（根据业务需求决定）
                                downLatch.countDown();
                            });
                        }
                );
        // 用于使主线程等待所有线程都已结束（根据业务需求决定）
        downLatch.await();
        // 关闭线程服务
        executorService.shutdown();
        System.err.println("{总耗时:}" + (System.currentTimeMillis() - start) + "ms，结果:" + a.get());
    }

}
