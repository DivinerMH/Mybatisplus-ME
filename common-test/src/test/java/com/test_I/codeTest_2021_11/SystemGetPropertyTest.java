package com.test_I.codeTest_2021_11;

import org.junit.Test;

import java.util.Properties;

/**
 * @Author: menghuan
 * @Date: 2021/10/28 9:37
 */
public class SystemGetPropertyTest {


    /**
     * 通过System.getPropertys()和 System.getProperty()变量所有系统属性的方法
     */
    @Test
    public void getPropertyTest_One(){
        //获取所有的属性
        Properties properties = System.getProperties();
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            //输出对应的键和值
            System.out.println(key + "=" + properties.getProperty(key));
        }
    }

    @Test
    public void getPropertyTest_Two(){
        //获取所有的属性
        Properties properties = System.getProperties();
        //为了看看系统的属性有几个，加了一个计数器
        int count = 0;
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            System.out.println(key + "=" + properties.getProperty(key));
            count++;
            if (key.equalsIgnoreCase("jdbc.drivers")){
                System.out.println("===============YES===============");
                return ;
            }

        }
        System.out.println(count);
    }

    @Test
    public void getPropertyTest_Three(){

        /*DriverManager中的jdbc.drivers这个系统属性不是本来系统自带的，需要用户自己设定采用*/
        System.setProperty("jdbc.drivers","aaa.bbb.ccc");

        //获取所有的属性
        Properties properties = System.getProperties();
        //为了看看系统的属性有几个，加了一个计数器
        int count = 0;
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            System.out.println(key + "=" + properties.getProperty(key));
            count++;
            if (key.equalsIgnoreCase("jdbc.drivers")){
                System.out.println("===============YES===============");
                return ;
            }

        }
        System.out.println(count);
    }


}
