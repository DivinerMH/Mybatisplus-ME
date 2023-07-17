package java.com.menghuan.menghuan.MultiThreaded;

import org.junit.Test;

/**
 * @Author: menghuan
 * @Date: 2021/7/28 14:58
 * extends Thread 没有强制要求重写 run()方法
 */
public class MyThread extends Thread {

    @Test
    public void TestThreadOne(){
        // 创建线程对象;
        MyThread myThread = new MyThread();
        // 自定义线程名称
        myThread.setName("ThreadMH-20210728");
        // 启动(调用)线程;
        myThread.start();
    }

    @Test
    public void TestThreadTwo(){
        // 创建线程对象;
        MyThread myThread = new MyThread();
        // 自定义线程名称
        myThread.setName("ThreadMH-20210728");
        // 开发过程中，不要手动调用 run() 方法，调用 start() 方法后系统会自动调用 run() 方法
        myThread.run();
    }

    /**
     * 重写 run方法； (继承没有强制要求重写 run()方法;)
     */
    public void run(){
        //获得当前执行的线程
        System.out.println(Thread.currentThread().getName() + " 线程已启动！");
    }

}
