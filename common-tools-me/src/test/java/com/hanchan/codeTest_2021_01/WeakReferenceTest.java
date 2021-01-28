package com.hanchan.codeTest_2021_01;

        import java.lang.ref.WeakReference;

/**
 * @Author: menghuan
 * @Date: 2021/1/20 16:30
 */
public class WeakReferenceTest {

    public static void main(String[] args) {

        WeakReference<String> sr = new WeakReference<String>(new String("hello"));

        System.out.println("未通知JVM的gc进行垃圾回收之前：" + sr.get());
        System.gc();                 //通知JVM的gc进行垃圾回收
        System.out.println("已通知JVM的gc进行垃圾回收之后：" + sr.get());
    }

}
