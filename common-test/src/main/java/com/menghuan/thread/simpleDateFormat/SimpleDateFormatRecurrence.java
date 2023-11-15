package com.menghuan.thread.simpleDateFormat;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleDateFormatRecurrence {

    /**
     * 执行总次数
     */
    private static final int EXECUTE_COUNT = 1000;

    /**
     * 同时运行的线程数量
     */
    private static final int THREAD_COUNT = 20;

    /**
     * SimpleDateFormat对象
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(THREAD_COUNT);
        final CountDownLatch countDownLatch = new CountDownLatch(EXECUTE_COUNT);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < EXECUTE_COUNT; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    try {
                        simpleDateFormat.parse("2022-10-10");
                    } catch (Exception e) {
                        log.error("线程:{}格式化日期失败;原因:", Thread.currentThread().getName(), e);
                        System.exit(1);
                    }
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("信号量发生错误;原因:", e);
                    System.exit(1);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("所有线程格式化日期成功");
    }
}