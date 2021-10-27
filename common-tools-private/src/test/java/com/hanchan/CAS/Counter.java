package com.hanchan.CAS;

/**
 * 程序会开100个线程，每个线程都会把counter 加一。
 *      那么应该有一个线程拿到counter =100的值，但实际运行情况是大多数据情况下拿不到100，在少数情况能拿到100.
 * @Author: menghuan
 * @Date: 2021/7/30 16:54
 */
public class Counter {

    private static long counter = 0;

    public static long addOne() {
        return ++counter;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        if (Counter.addOne() == 100) {
                            System.out.println("counter = 100");
                        }
                        // System.out.println("result : " + Counter.addOne());
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }

    /*public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 100; i++) {
                int finalJ = j;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                            if (Counter.addOne() == 100) {
                                System.out.println("次数计数 : " + finalJ);
                                System.out.println("counter = 100");
                            }
                            // System.out.println("result : " + Counter.addOne());
                        } catch (InterruptedException e) {

                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
            }
        }
    }*/

}
