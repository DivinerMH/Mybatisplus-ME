package com.hanchan.codeTest_2021_02.Thread;

/**
 * @Author: menghuan
 * @Date: 2021/2/2 17:43
 */
public class ThreadInterruptDemo implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadInterruptDemo(), "MyThreadInterruptDemo");
        System.out.println("……………..start………………");
        thread.start();
        Thread.sleep(2000);
        System.out.println("……………..Interrupted………………");
        thread.interrupt();
        System.out.println("线程是否中断" + thread.isInterrupted());
        System.out.println("……………..Stopping………………");
    }

    @Override
    public void run() {
    }

}
