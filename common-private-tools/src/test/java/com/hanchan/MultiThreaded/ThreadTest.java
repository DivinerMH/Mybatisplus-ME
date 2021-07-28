package com.hanchan.MultiThreaded;

import java.util.concurrent.CountDownLatch;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadTest t = new ThreadTest();
        // t.method();
        t.method2();
    }

    private void method() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("method 执行结束，耗时：" + (end - start));
    }

    private void method2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 200; i++) {
                        System.out.println(i);
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("method2 执行结束，耗时：" + (end - start));
    }
}
