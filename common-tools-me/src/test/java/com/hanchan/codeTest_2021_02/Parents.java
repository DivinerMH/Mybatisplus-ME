package com.hanchan.codeTest_2021_02;

/**
 * @Author: menghuan
 * @Date: 2021/1/27 14:39
 */
public class Parents {

    // 默认无参构造方法
    Parents(){
        System.out.print(" Parents父类构造方法！ -->");
    }

    // 非静态代码块
    {
        System.out.print(" Parents父类非静态代码块！ -->");
    }

    // 静态代码块
    static {
        System.out.print(" Parents父类静态代码块！ -->");
    }

    public static void  test(){
        {
            System.out.print(" Parents父类普通方法中的代码块！ ");
        }
    }

    public static void  main(String[] args) {
        System.out.print(" Parents父类的main方法！ --> ");
        new Childs();
    }


}
