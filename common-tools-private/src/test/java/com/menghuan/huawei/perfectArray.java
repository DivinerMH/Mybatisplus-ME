package com.menghuan.huawei;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: menghuan
 * @Date: 2021/3/3 12:38
 *
 * 【30,60】之间完美数的个数，完美数字定义为能同时被2,3,5整除。
 */
public class perfectArray {

    @Test
    public void perfectArrayOne() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入数字a:");
        int a = s.nextInt();
        System.out.println("请输入数字b:");
        int b = s.nextInt();
        s.close();
        int count = 0;

        if(a <= b &&  a < 10000 &&  a >= 0 && b < 10000 &&  b >= 0){
            for(int m = a; m <= b; m++){
                if( m % 2 == 0 && m % 3 == 0 && m % 5 == 0){
                    count++;
                }
            }
        }else{
            System.out.println("提示：请输入0-10000范围的数字");
            return;
        }
        System.out.print("目标区域完美个数：" + count);
    }


    @Test
    public void perfectArrayTwo() {
        Map map = paramDeal();
        System.out.println("map" + map);
        Integer integerNum = perfectNumber(map);
        System.out.println("目标区域完美个数：" + integerNum);
    }

    private static Map paramDeal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字a:");
        int a = scanner.nextInt();
        System.out.println("请输入数字b:");
        int b = scanner.nextInt();
        Map<String,Integer> map = new HashMap();

        if(a == b){
            System.out.println("数字不能相等，请重新输入：================");
            Map map1 = paramDeal();
            return map1;
        }else if(a > b) {
            map.put("min", b);
            map.put("max", a);
            return map;
        }else {
            map.put("min", a);
            map.put("max", b);
            return map;
        }
    }

    private static Integer perfectNumber(Map<String,Integer> map){
        int count = 0;
        for (int m = map.get("min"); m <= map.get("max") ; m++){
            if(m%2 == 0 && m%3 == 0 && m%5 == 0){
                count++;
                System.out.println("完美数字：" + m);
            }
        }
        return count;
    }



}
