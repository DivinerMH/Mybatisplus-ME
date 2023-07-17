package java.com.menghuan.menghuan.MultiThreadedOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: menghuan
 * @Date: 2021/8/24 15:36
 */
public class ThreadPoolByNewSingleThreadExecutor3 {

    public static void main(String[] args) {
        /**
         * 单线程化的线程池
         */
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("Thread i = " + index);
                    System.out.println("当前线程名称" + Thread.currentThread().getName() + " 循环标识:index = " + index);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("ssss");
                    }
                }
            });
        }
        try {
            // timeout 控制顺利可执行的线程数 3*1000 / 500 = 6 ; 即当前配置允许6个线程顺利执行，超过6个不允许加入
            if (!singleThreadExecutor.awaitTermination(3*1000, TimeUnit.MILLISECONDS)) {
                singleThreadExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // awaitTermination方法被中断的时候也中止线程池中全部的线程的执行。
            System.out.println("awaitTermination interrupted: " + e);
            singleThreadExecutor.shutdownNow();
        }
        System.out.println("on the main thread...");

    }

}
