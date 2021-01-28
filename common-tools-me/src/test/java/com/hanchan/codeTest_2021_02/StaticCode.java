package com.hanchan.codeTest_2021_02;

/**
 * @Author: menghuan
 * @Date: 2021/1/27 14:39
 */
public class StaticCode {

    // 默认无参构造方法
    public StaticCode(){
        System.out.print(" 默认构造方法！ -->");
    }

    // 非静态代码块
    {
        System.out.print(" 非静态代码块！ -->");
    }

    // 静态代码块
    static {
        System.out.print(" 静态代码块！ -->");
    }

    public static void  test(){
        {
            System.out.println(" 普通方法中的代码块！ ");
        }
    }


}
