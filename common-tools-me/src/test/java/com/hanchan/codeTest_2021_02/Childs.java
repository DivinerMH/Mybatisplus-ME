package com.hanchan.codeTest_2021_02;

/**
 * @Author: menghuan
 * @Date: 2021/1/27 14:39
 */
public class Childs extends Parents {

    // 默认无参构造方法
    Childs(){
        System.out.print(" Child子类构造方法！ -->");
    }

    // 非静态代码块
    {
        System.out.print(" Child子类非静态代码块！ -->");
    }

    // 静态代码块
    static {
        System.out.print(" Child子类静态代码块！ -->");
    }

    public static void  test(){
        {
            System.out.print(" Child子类普通方法中的代码块！ ");
        }
    }

    public static void  main(String[] args) {
        System.out.print(" Child子类的main方法！ --> ");
        new Childs();
    }


}
