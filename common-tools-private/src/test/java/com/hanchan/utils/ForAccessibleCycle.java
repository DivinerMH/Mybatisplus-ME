package com.hanchan.utils;

import java.util.Date;


/**
 * @Author:menghuan
 * @Date:2019/12/26 17:15
 */
public class ForAccessibleCycle {

    public static void main(String[] args) {

        // 下面的for循环，只需输入100.fori按回车就可以出来
        for (int i = 0; i < 100; i++) {

        }

        // 下面的for循环，只需输入50.fori按回车就可以出来
        for (int i = 0; i < 50; i++) {

        }


        // 下面的for循环，只需输入2000.forr按回车就可以出来
        for (int i = 2000; i > 0; i--) {

        }

        // new Date().sout
        System.out.println(new Date());


        System.out.println("usernmea is jone");//username拼写错误，单词下会出现波浪线
        //按下alt+enter，出现Typo Change to...
        //Intellij会给出一些建议的单词


        fn1();

    }

    private static void fn1() {
    }

    void m(Object o) {
        // o.nn
        if (o != null) {
            System.out.println("ture");
        }
    }


/*    for (int i = 0; i < list.size(); i++) {
        String item = list.get(i);
    }*/

    // List<T>

}
