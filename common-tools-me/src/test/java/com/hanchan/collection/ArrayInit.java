package com.hanchan.collection;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: menghuan
 * @Date: 2021/3/1 16:06
 */
public class ArrayInit {

    @Test
    public void arrayCreate(){
        // 数组声明
        int[] score;
        // 数组创建
        // score = new int[5];
        score = new int[]{2, 3, 45, 56};
        System.out.println("数组创建" + Arrays.toString(score));

    }

    @Test
    public void arrayStaticInit(){
        // 数组创建
        int[] score = new int[5];
        System.out.println("数组创建" + Arrays.toString(score));

        // 数组赋值:有数组，等号左侧一定是空的
        // 静态初始化
        int[] len = {2,3,45,56};
        int[] ken = new int[] {0,1,2,3,5};
        // 一个个进行赋值
        score[0] = 20;
        score[4] = 985;
        System.out.println("静态初始化 len" + Arrays.toString(len));
        System.out.println("静态初始化 ken" + Arrays.toString(ken));
        System.out.println("静态初始化 ken" + Arrays.toString(score));

    }

    @Test
    public void arrayDynamicInit(){
        // 数组创建
        int[] score = new int[5];
        System.out.println("数组创建" + Arrays.toString(score));

        // 数组赋值:有数组，等号左侧一定是空的
        // 动态初始化
        for (int i = 0; i < score.length; i++) {
            score[i] =  i + 10;
        }
        System.out.println("动态初始化" + Arrays.toString(score));

    }

}
