package java.com.menghuan.menghuan.fourQuote;

import java.util.UUID;

/**
 * @Author: menghuan
 * @Date: 2021/1/20 17:30
 */
public class StrongReferenceTest {

    public static void main(String[] args) {
        new StrongReferenceTest().fun1();
    }

    public void fun1() {
        Object object = new Object();
        Object[] objArr = new Object[1000];

        object = UUID.randomUUID().toString();

        System.out.println("未通知JVM的gc进行垃圾回收之前：" + object);
        System.gc();                 //通知JVM的gc进行垃圾回收
        System.out.println("已通知JVM的gc进行垃圾回收之后：" + object);
    }
}
