package com.menghuan.dataConversion;

/**
 * @Author:menghuan
 * @Date:2020/12/22 15:47
 */


import java.util.Scanner;

/**
 * 请编写程序，由用户输入若干个罗马数字串，程序输出对应的十进制表示。
 * <p>
 * 输入格式是：第一行是整数n,表示接下来有n个罗马数字(n<100)。以后每行一个罗马数字。罗马数字大小不超过999。
 * <p>
 * 要求程序输出n行，就是罗马数字对应的十进制数据。
 * <p>
 * 例如，用户输入： 3 LXXX XCIII DCCII
 * <p>
 * 则程序应该输出： 80 93 702
 *
 * @author Administrator
 */
public class RomeToArabic {

    /*
     * 学习要点：
     *      1.运用递归的思想，找出罗马字符串中最大的元素，对左边的处理是减去，对右边的处理是加上；
     *      2.递归头是字符串只剩下一个元素时，或者右边的下标小于左边的下标；
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("程序员之家测试结果：");
        Scanner mScanner = new Scanner(System.in);
        System.out.println(r2a(mScanner.nextLine()));
        System.out.println(a2r(mScanner.nextInt()));
    }

    /**
     * 把罗马数字转换为阿拉伯数字
     *
     * @param m
     * @return
     */
    public static int r2a(String m) {
        int[] graph = new int[400];
        graph['I'] = 1;
        graph['V'] = 5;
        graph['X'] = 10;
        graph['L'] = 50;
        graph['C'] = 100;
        graph['D'] = 500;
        graph['M'] = 1000;
        char[] num = m.toCharArray();
        int sum = graph[num[0]];
        for (int i = 0; i < num.length - 1; i++) {
            if (graph[num[i]] >= graph[num[i + 1]]) {
                sum += graph[num[i + 1]];
            } else {
                sum = sum + graph[num[i + 1]] - 2 * graph[num[i]];
            }
        }
        return sum;
    }

    /**
     * 把阿拉伯数字转换为罗马数字
     *
     * @param number
     * @return
     */
    public static String a2r(int number) {
        String rNumber = "";
        int[] aArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] rArray = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I"};
        if (number < 1 || number > 3999) {
            rNumber = "-1";
        } else {
            for (int i = 0; i < aArray.length; i++) {
                while (number >= aArray[i]) {
                    rNumber += rArray[i];
                    number -= aArray[i];
                }
            }
        }
        return rNumber;
    }
}

