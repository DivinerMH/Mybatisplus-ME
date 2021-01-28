package com.hanchan.codeTest_2021_01;

import java.lang.ref.SoftReference;

/**
 * @Author: menghuan
 * @Date: 2021/1/20 16:26
 */
public class SoftReferenceTest {


    public static void main(String[] args) {

        SoftReference<String> sr = new SoftReference<String>(new String("hello"));

        System.out.println("未通知JVM的gc进行垃圾回收之前：" + sr.get());
        System.gc();                 //通知JVM的gc进行垃圾回收
        System.out.println("已通知JVM的gc进行垃圾回收之后：" + sr.get());
    }

}
