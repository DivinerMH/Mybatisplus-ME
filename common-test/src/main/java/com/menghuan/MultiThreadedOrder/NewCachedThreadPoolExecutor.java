package com.menghuan.MultiThreadedOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: menghuan
 * @Date: 2021/8/24 17:53
 *
 */
public class NewCachedThreadPoolExecutor {

    public static void main(String[] args) {
        ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            cachedThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": index = " + index);
                }
            });
        }
        cachedThreadExecutor.shutdown();
    }

}
