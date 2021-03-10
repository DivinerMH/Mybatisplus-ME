package com.hanchan.huawei;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author: menghuan
 * @Date: 2021/3/3 15:16
 */
public class dateSort {

    @Test
    public void dateSortOne(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请确定比较参数个数:");
        int n = scanner.nextInt();
        // 拼接成字符串数组
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        // 对字符串数组进行排序，并遍历打印
        String[] ruslutStrs = sort(strings);

        for (int i = 0; i <ruslutStrs.length ; i++) {
            System.out.println(ruslutStrs[i]);
        }
    }

    // 双重for循环，排序
    private static String[] sort(String[] strs) {
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = 0; j < strs.length - i - 1; j++) {
                // M G T
                // 前数据 > 后数据 -- 为真则进行调换
                if (compare(strs[j], strs[j + 1])) {
                    // 中间变量 - 缓存临时数据
                    String tem = strs[j];
                    strs[j] = strs[j+1];
                    strs[j+1] = tem;
                }
            }
        }
        return strs;
    }

    // 比较经过数据清洗的同一单位数据，得到 boolean
    private static boolean compare(String str1, String str2){
        int str1M = turnString(str1);
        int str2M = turnString(str2);
        return str1M > str2M;
    }

    // 计量单位换算（统一化处理M）
    private static int turnString(String str){
        if("M".equals(String.valueOf(str.charAt(str.length()-1)))){
            return Integer.parseInt(str.substring(0,str.length()-1));
        }
        else if ("G".equals(String.valueOf(str.charAt(str.length()-1)))){
            return Integer.parseInt(str.substring(0,str.length()-1))*1024;
        }
        else if ("T".equals(String.valueOf(str.charAt(str.length()-1)))){
            return Integer.parseInt(str.substring(0,str.length()-1))*1024*1024;
        }
        return 0;
    }

}
