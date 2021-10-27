package com.hanchan.stringJSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: menghuan
 * @Date: 2020/3/23 19:08
 */
public class StringChanges {

    @Test
    public void StringChanges2(){
        // String适用于少量的字符串操作的情况，将其改变为可直接转换为数组的状态
        String str = new String("-0-3-5-9-");
        System.out.println("str1:"+str);
        String str2 = str.replaceAll("-", ",");
        System.out.println("str2:"+str2);
        String substring = str2.substring(1);
        System.out.println("str3:"+substring);
       // 把字符串转换为字符数组
        String[] arr = substring.split(",");
        String str4 = Arrays.toString(arr);
        System.out.println("str4:"+ str4);
        // 已转换为数组
        for(String s : arr){
            System.out.println("一维数组增强:for:"+s);
        }
    }

    @Test
    public void StringChanges3() {
        // TODO Auto-generated method stub
        // 将字符数组转为字符串
        // 方法一
        char[] data = {'a', 'b', 'c'};// 字符数组
        String str = new String(data);
        System.out.println(str);
        // 方法二
        String str1 = String.valueOf(data);
        System.out.println(str1);
    }

    @Test
    public void StringChanges4(){
        // 将字符串转为字符串数组
        // 方法一
        String string = "abc,def,ghi";
        String[] strArr = string.split(",");//注意分隔符是需要转译
        System.out.println(strArr);
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }
        // 方法二
        String string1 = "abcdefghijk";
        char[] strArr1 = string1.toCharArray();
        for (int i = 0; i < strArr1.length; i++) {
            System.out.println(strArr1[i]);
        }
    }

    @Test
    public void StringChanges5() {
        // String适用于少量的字符串操作的情况，将其改变为可直接转换为数组的状态
        String str = new String("-0-3-5-9-");
        System.out.println("str1:" + str);
        String str2 = str.replaceAll("-", ",");
        System.out.println("str2:" + str2);
        String substring = str2.substring(1);
        System.out.println("str3:" + substring);
        // 把字符串转换为字符数组
        String[] arr = substring.split(",");
        String str4 = Arrays.toString(arr);
        System.out.println("str4:" + str4);
        //输出java数组
        String str5 = new String();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);//输出结果 1 2 3
            str5 = str5 + "/" + arr[i];
            System.out.println("str5:" + str5);
        }
        /* for (int i = arr.length-1;i < arr.length; i++) {
            System.out.println(arr[i]);//输出结果 1 2 3
            str5 = str5 + arr[i];
            System.out.println("str6:" + str5);
        }*/
    }
    @Test
    public void StringChanges6() {
        // 字符串转数组  java.lang.String
        String str = "-0-1-2-3-4-5-";
        str = str.substring(3);
        String[] arr = str.split("-"); // 用,分割
        System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4, 5]
        String str2 = new String();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);//输出结果 1 2 3
            str2 = str2 + "/" + arr[i];
            System.out.println("str2:" + str2);
        }
        String substring = str2.substring(1);
        System.out.println("substring:" + substring);
    }

}
