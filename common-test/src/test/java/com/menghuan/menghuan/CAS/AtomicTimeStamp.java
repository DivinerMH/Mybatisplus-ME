package java.com.menghuan.menghuan.CAS;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 工程里有获取唯一时间戳作为id的需求,用乐观锁cas实现,自旋.
 * cas原子性操作获得了绝对唯一的时间戳 (系统时间:纳秒版本). ---- 单机有效,不能分布式调用.
 *
 * https://blog.csdn.net/qq_36402372/article/details/83753395
 *
 * @Author: menghuan
 * @Date: 2021/7/29 10:22
 */
public class AtomicTimeStamp {

    private static AtomicLong at = new AtomicLong(0);
    // 原子变量操作类
    // JDK在concurrent包里提供了一些线程安全的基本数据类型的实现，比如 Long型对应的concurrent包的类是AtomicLong
    private AtomicLong timeMills = new AtomicLong(0);

    public static void main(String[] args) {
        AtomicTimeStamp stamp = new AtomicTimeStamp();
        // 构建线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                100,
                150,
                200,
                TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<>(100),
                new ThreadFactoryBuilder().build()
        );
        long l = System.currentTimeMillis();
        System.out.println("当前唯一时间戳 ：" + l);

        //开启三个线程测试成功性,at自增,测试10S会有多少个成功的
        poolExecutor.execute(() -> {
            while (true) {
                // 获取唯一时间戳
                stamp.getNextNanos();
                // 调用unsafe方法，原子性设置当前值自增1，返回修改前的值
                at.getAndIncrement();
                long l1 = System.currentTimeMillis();
                if (l1 > l + 10000 & l1 < l + 10010) {
                    System.out.println(at.longValue());
                }
            }
        });
        poolExecutor.execute(() -> {
            while (true) {
                stamp.getNextNanos();
                at.getAndIncrement();
                long l1 = System.currentTimeMillis();
                if (l1 > l + 10000 & l1 < l + 10010) {
                    System.out.println(at.longValue());
                }
            }
        });
        poolExecutor.execute(() -> {
            while (true) {
                stamp.getNextNanos();
                at.getAndIncrement();
                long l1 = System.currentTimeMillis();
                if (l1 > l + 10000 & l1 < l + 10010) {
                    System.out.println(at.longValue());
                }
            }
        });
    }

    /**
     * System.nanoTime()返回的是纳秒，nanoTime而返回的可能是任意时间，甚至可能是负数
     * System.currentTimeMillis()返回的毫秒，这个毫秒其实就是自1970年1月1日0时起的毫秒数 (两个方法都不能保证完全精确,精确程度依赖具体的环境.)
     *
     * @return 唯一时间戳
     */
    public Long getNextNanos() {
        while (true) {
            // 返回的是纳秒
            long currentTimeMillis = System.nanoTime();
            long currentMill = timeMills.get();
            if (currentTimeMillis > currentMill && timeMills.compareAndSet(currentMill, currentTimeMillis)) {
                // 返回唯一时间戳
                return currentTimeMillis;
            }
        }
    }


}
