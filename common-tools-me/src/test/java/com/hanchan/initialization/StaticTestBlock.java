package com.hanchan.initialization;

import java.util.Random;

/**
 * @Author: menghuan
 * @Date: 2021/2/2 9:57
 */
public class StaticTestBlock {

    public static StringBuffer messageBuffer = new StringBuffer("这是一个静态变量");

    // 使用静态代码块，对静态变量进行复杂的赋值操作
    static {
        Random random = new Random();
        messageBuffer
                .append("里面包含一个随机数:")
                .append(random.nextInt(1000));
    }

    /**
     * 因为静态代码块运行和静态变量的加载都是在java虚拟机加载类时进行的，
     * 所以当我们使用使用静态变量时，静态代码块里的语句已经执行，取到的结果是执行之后的结果
     * @param args
     */
    public static void main(String[] args){
        System.out.println(messageBuffer);
    }


}