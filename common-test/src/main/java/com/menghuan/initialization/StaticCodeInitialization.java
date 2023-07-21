package com.menghuan.initialization;

import org.junit.jupiter.api.Test;

/**
 * @Author: menghuan
 * @Date: 2021/1/27 14:39
 */
public class StaticCodeInitialization {

    // 类变量
    private static String CCTV;

    // 静态代码块
    static {
        CCTV = "2021.01.27,中央新闻广播电视台欢迎您";
        System.out.println("CCTV:" + CCTV);
        System.out.print("静态代码块初始化类变量");
    }

    @Test
    public void test() {

    }

    @Test
    public void test2() {
        CCTV = "null";
        System.out.println("CCTV:" + CCTV);
    }

}
