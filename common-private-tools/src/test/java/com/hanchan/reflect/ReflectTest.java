package com.hanchan.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * https://blog.csdn.net/leyi520/article/details/118544652  java的上乘武功，反射
 * @Author: menghuan
 * @Date: 2021/7/8 14:14
 */
public class ReflectTest {

    /**
     * 打印对象的类名
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param o 对象
     */
    public static void printClass(Object o) {
        System.out.printf(o.getClass().getName());
    }

    @Test
    public void testOne() {
        printClass(new ArrayList<>());
    }

    /**
     * 打印类的属性
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param clazz
     */
    public static void printFields(Class clazz) {
        System.out.println(clazz.getName() + "包含如下属性：");
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f);
        }
    }

    @Test
    public void testTwo() {
        printFields(MyClass.class);
    }


    /**
     * 打印类的方法
     * @author 二当家的白帽子 https://le-yi.blog.csdn.net/
     * @param clazz
     */
    public static void printMethods(Class clazz) {
        System.out.println(clazz.getName() + "包含如下方法：");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m);
        }
    }

    @Test
    public void testThree() {
        printMethods(MyClass.class);
    }

    /**
     * 调用一个对象的方法
     * @param o
     * @param methodName
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void callMethod(Object o, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method m = o.getClass().getDeclaredMethod(methodName);
        m.setAccessible(true);
        m.invoke(o);
    }

    /**
     * 修改一个对象的属性
     * @param o
     * @param fieldName
     * @param value
     * @throws IllegalAccessException
     */
    public static void changeFieldValue(Object o, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field f = o.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        f.set(o, value);
    }

    @Test
    public void testFour() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        MyClass o = new MyClass();

        // 修改任意属性，即使是私有的
        changeFieldValue(o, "name", "二当家的白帽子");
        System.out.println(o);

        // 调用任意方法，即使是私有的
        callMethod(o, "getName");
    }




}
