package com.menghuan.MultiThreaded;

import java.util.concurrent.*;

/**
 * @Author: menghuan
 * @Date: 2021/7/28 16:30
 */
public class MyThreadPoolExecutor {

    public static void main(String[] args) throws Exception {

        // 有界队列
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
        // 放弃拒绝的任务并抛出异常
        RejectedExecutionHandler abortPolicyHandler = new ThreadPoolExecutor.AbortPolicy();
        RejectedExecutionHandler discardPolicyHandler = new ThreadPoolExecutor.DiscardPolicy();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                        5,
                        10,
                        30,
                        TimeUnit.SECONDS,
                        workQueue,
                        discardPolicyHandler);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 40; i++) {
            threadPool.execute(new MyTask());
            System.out.println("核心线程数" + threadPool.getCorePoolSize());
            System.out.println("最大线程数" + threadPool.getMaximumPoolSize());
            System.out.println("线程池数" + threadPool.getPoolSize());
            System.out.println("队列任务数" + threadPool.getQueue().size());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }

        System.out.println(System.currentTimeMillis()-start);
        threadPool.shutdown();
        if (threadPool.awaitTermination(6, TimeUnit.SECONDS)) {
            threadPool.shutdownNow();
        }
    }

}

class MyTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ", hello");
    }

}
