package com.menghuan.MultiThreadedOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: menghuan
 * @Date: 2021/8/24 15:14
 * 通过SingleThreadExecutor让线程按顺序执行
 */
public class ThreadPoolByNewSingleThreadExecutor {

    // 单线程化线程池
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws Exception {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开发人员开发新需求功能");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("测试人员测试新功能");
            }
        });

        System.out.println("早上：");
        System.out.println("产品经理来上班了");
        System.out.println("测试人员来上班了");
        System.out.println("开发人员来上班了");
        System.out.println("领导吩咐:");
        System.out.println("首先，产品经理规划新需求...");
        // 此线程池保证所有任务的执行顺序按照任务的提交顺序执行
        executorService.submit(thread1);
        System.out.println("然后，开发人员开发新需求功能...");
        executorService.submit(thread2);
        System.out.println("最后，测试人员测试新功能...");
        executorService.submit(thread3);
        // 关闭线程池，拒绝新任务(线程池不会立刻退出，直到添加到线程池中的任务都已经处理完成，才会退出，即在终止前允许执行以前提交的任务)
        executorService.shutdown();
    }
}
