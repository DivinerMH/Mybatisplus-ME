package com.menghuan.outOfMemory;

import cn.hutool.core.lang.UUID;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: menghuan
 * @Date: 2021/6/22 17:47
 */
public class BlowUpJVM {

    // 栈深度溢出
    @Test
    public void testStackOverFlow(){
        testStackOverFlow();
    }

    // 永久代内存溢出
    @Test
    public void testPergemOutOfMemory1(){
        //方法一失败
        List<String> list = new ArrayList<String>();
        while(true){
            list.add(UUID.randomUUID().toString().intern());
        }
    }
    // 打算把 String 常量池堆满，没想到失败了，JDK1.7 后常量池放到了堆里，也能进行垃圾回收了。

    // 然后换种方式，使用 cglib，用 Class 把老年代堆满。
    @Test
    public void testPergemOutOfMemory2(){
        try {
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOM.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper(obj, args);
                    }
                });
                enhancer.create();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    // 本地方法栈溢出
    @Test
    public void testNativeMethodOutOfMemory(){
        int j = 0;
        while(true){
            System.out.println(j++);
            // Printer.println(j++);
            ExecutorService executors = Executors.newFixedThreadPool(50);
            int i=0;
            while(i++<10){
                executors.submit(new Runnable() {
                    public void run() {
                    }
                });
            }
        }
    }

    // 堆溢出
    @Test
    public void testOutOfHeapMemory(){
        List<StringBuffer> list = new ArrayList<StringBuffer>();
        while(true){
            StringBuffer B = new StringBuffer();
            for(int i = 0 ; i < 10000 ; i++){
                B.append(i);
            }
            list.add(B);
        }
    }



}
