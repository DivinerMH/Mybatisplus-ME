package com.test_I.codeTest_2020_12;

import org.junit.Test;

/**
 * @Author: menghuan
 * @Date: 2021/1/27 15:53
 */
public class DataClassTest {

    @Test
    public void test() {
        // 创建类的对象
        DataClass dc = new DataClass();

        // 对象名.变量名调用实例变量（全局变量）
        System.out.println(dc.name);
        System.out.println(dc.age);

        // 对象名.变量名调用静态变量（类变量）
        System.out.println(dc.website);
        System.out.println(dc.URL);

        // 类名.变量名调用静态变量（类变量）
        System.out.println(DataClass.website);
        System.out.println(DataClass.URL);
    }

    @Test
    public void test2() {
        // 创建类的对象
        DataClass dc = new DataClass();

        // 对象名.变量名调用实例变量（全局变量）
        System.out.println(dc.name);
        System.out.println(dc.age);

        // 对象名.变量名调用静态变量（类变量）
        // dc.website = "222222";
        System.out.println(dc.website);
        dc.URL = "333333";
        System.out.println(dc.URL);

        // 类名.变量名调用静态变量（类变量）
        // DataClass.website = "444444";
        System.out.println(DataClass.website);
        DataClass.URL = "555555";
        System.out.println(DataClass.URL);
    }
    
}
