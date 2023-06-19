package com.menghuan.MultiThreadedOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: menghuan
 * @Date: 2021/8/24 17:29
 */
public class ThreadPoolByNewFixedThreadPool {

    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("Thread i = " + index);
                    System.out.println("当前线程名称" + Thread.currentThread().getName() + " 循环标识:index = " + index);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("exception");
                    }
                }
            });
        }
        newFixedThreadPool.shutdown();
        System.out.println("on the main thread...");
    }

}
