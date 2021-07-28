package com.hanchan.MultiThreaded;

import org.junit.Test;

/**
 * @Author: menghuan
 * @Date: 2021/7/28 15:18
 * implements Runnable 强制要求重写 run()方法
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        //获得当前执行的线程
        System.out.println("线程已启动！"+Thread.currentThread().getName());
    }

    @Test
    public void TestMyRunnable(){
        //创建Thread 对象,传入Runnable对象;
        //启动方式1
        Thread thread =new Thread(new MyRunnable());
        //启动方式2
        Thread thread2 =new Thread(new Runnable(){
            @Override
            public void run() {
                //获得当前执行的线程
                System.out.println("线程已启动！"+Thread.currentThread().getName());
            }
        });
        //启动方式3
        Thread thread3 =new Thread(()->
                System.out.println("线程已启动！"+Thread.currentThread().getName()));
        //调用;
        thread.start();
        thread2.start();
        thread3.start();
        //thread.run();
    }

}
