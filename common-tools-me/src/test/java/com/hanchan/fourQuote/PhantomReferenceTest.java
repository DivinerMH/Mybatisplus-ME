package com.hanchan.fourQuote;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Author: menghuan
 * @Date: 2021/1/20 17:13
 */
public class PhantomReferenceTest {

    public static void main(String[] args) {

        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);

        System.out.println("未通知 JVM 的gc进行垃圾回收之前，虚引用的get方法：" + pr.get());
        System.out.println("未通知 JVM 的gc进行垃圾回收之前，引用队列数据：" + queue.toString());
        System.gc();                 //通知JVM的gc进行垃圾回收
        System.out.println("已通知 JVM 的gc进行垃圾回收之后，虚引用的get方法：" + pr.get());
        System.out.println("已通知 JVM 的gc进行垃圾回收之后，引用队列数据：" + queue.toString());
    }
}
