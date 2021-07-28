package com.hanchan.MultiThreaded;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: menghuan
 * @Date: 2021/7/28 15:40
 */
public class MyCallable {

    @Test
    public void TestMyCallable() throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello world 2021.07.28 中国奥运健儿，加油";
            }
        });

        Thread thread = new Thread(future);
        thread.setName("myCallable001");
        thread.start();
        while(!future.isDone())

        {
            try {
                System.out.println("myCallable001 is not done");
                //等待线程运行结束
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        String result = future.get();
        System.out.println("result : "+result);
    }

}
