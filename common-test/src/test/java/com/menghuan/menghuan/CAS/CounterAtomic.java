package java.com.menghuan.menghuan.CAS;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 在多线程环境下，可以简单使用 AtomicXXX 使代码变得线程安全
 * @Author: menghuan
 * @Date: 2021/7/30 16:54
 */
public class CounterAtomic {

    private static AtomicLong counter = new AtomicLong(0);

    public static long addOne() {
        return counter.incrementAndGet();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                        if (CounterAtomic.addOne() == 100) {
                            System.out.println("counter = 100");
                        }
                        System.out.println("result : " + Counter.addOne());
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }

}
