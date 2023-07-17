package java.com.menghuan.menghuan.MultiThreadedOrder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: menghuan
 * @Date: 2021/8/24 15:23
 */
public class ThreadPoolByNewSingleThreadExecutor2 {


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
        singleThreadExecutor.shutdown();
        System.out.println("on the main thread...");

    }

}
