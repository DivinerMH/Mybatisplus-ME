package com.hanchan.codeTest_2020_07;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author:menghuan
 * @Date:2020/11/11 10:53
 */
public class ArrayDeal {

    public static void main(String[] args) {

    }

    @Test
    public void dealGisMap() {
        HashMap<String, String> map = new HashMap<>(8);

        String info = "[1,2]";
        String info2 = "[[1,2]]";
        String info3 = "[[11,22],[55,77]]";
        if (StringUtils.isNotBlank(info3)) {
            String str = info2;
            String str2 = str.substring(1, str.length() - 1);
            // "System.out.println("切割 str:" +  str3);"
            /* --------------------------------数组转换完成------------------------------ */
            String[] arr = str2.split(","); // 用,分割
            if(arr.length > 1){
                // "String s = arr[0] + "," + arr[1];"
                map.put("lng", arr[0].substring(1));
                map.put("lat", arr[1].substring(0, arr[1].lastIndexOf("]")));
                System.out.println(map);
            }
        }
        System.out.println(map);
    }

    @Test
    public void dealGisMap2() {
        HashMap<String, String> map = new HashMap<>(8);

        String info = "[1,2]";
        String info2 = "[[1,2]]";
        String info3 = "[[11,22],[55,77]]";
        if (StringUtils.isNotBlank(info3)) {
            String str = info3;
            String str2 = str.substring(1, str.length() - 1);
            // "System.out.println("切割 str:" +  str3);"
            /* --------------------------------数组转换完成------------------------------ */
            String[] arr = str2.split(","); // 用,分割
            System.out.println("arr:" + arr);
            Integer x = 0;
            Integer y = 0;
            for (int i = 0; i < arr.length; i++) {

                Integer x1 = Integer.parseInt(arr[i].substring(1));
                System.out.println(i + "x:" + x1);
                Integer y1 = Integer.parseInt(arr[i+1].substring(0, arr[1].lastIndexOf("]")));
                System.out.println((i+1) + "y:" + y1);
            }
        }
    }

    @Test
    public void dealGisMap3() {
        HashMap<String, String> map = new HashMap<>(8);

        String info = "[1,2]";
        String info2 = "[[1,2]]";
        String info3 = "[[11,22],[55,77]]";

        String strip = StringUtils.strip(info3, "[]");
        System.out.println("strip:"+strip);

    }

    @Test
    public void dealGisMap4() {
        HashMap<String, String> map = new HashMap<>(8);

        String info = "[1,2]";
        String info2 = "[[1,2]]";
        String info3 = "[[11,22],[55,77]]";
        if (StringUtils.isNotBlank(info3)) {
            String str = info3;
            String str2 = str.substring(1, str.length() - 1);
            // "System.out.println("切割 str:" +  str3);"
            /* --------------------------------数组转换完成------------------------------ */
            String[] arr = str2.split(","); // 用,分割
            System.out.println("arr:" + arr);
            Integer x = 0;
            Integer y = 0;
            for (String s : arr) {
                String strip = StringUtils.strip(s, "[]");
                System.out.println(strip);
            }
        }
    }


    @Test
    public void dealGisMap5() {
        HashMap<String, String> map = new HashMap<>(8);

        String info = "[1,2]";
        String info2 = "[[1,2]]";
        String info3 = "[[11,22],[55,77]]";
        String info4 = "[[116.41106966212932,39.91166740787578],[116.4121476287413,39.91170545653202]]";
        if (StringUtils.isNotBlank(info3)) {
            String str = info4;
            String str2 = str.substring(1, str.length() - 1);
            // "System.out.println("切割 str:" +  str3);"
            /* --------------------------------数组转换完成------------------------------ */
            String[] arr = str2.split(","); // 用,分割
            // System.out.println("arr:" + arr);
            Integer x = 0;
            Integer y = 0;
            for (int i = 0; i < arr.length; i++) {
                String strip = StringUtils.strip(arr[i], "[]");

                if ((i & 1) == 1) {
                    System.out.println("奇数-> X轴：" + strip );
                    x = x + Integer.parseInt(strip);
                } else {
                    System.out.println("偶数-> Y轴：" + strip );
                    y = y + Integer.parseInt(strip);
                }
            }
            Integer denominator = arr.length / 2;
            Integer  lng = (x / denominator);
            Integer  lat = (y / denominator);
            map.put("lng", lng.toString());
            map.put("lat", lat.toString());
            map.put("height", "0");
            System.out.println(map);

        }
    }

    @Test
    public void dealGisMap6() {
        HashMap<String, String> map = new HashMap<>(8);
        String info = "[1,2]";
        String info2 = "[[1,2]]";
        String info3 = "[[11,22],[55,77]]";
        String info4 = "[[116.41106966212932,39.91166740787578],[200.4121476287413,58.91170545653202],[250.4121835609617,73.910854545130455]]";
        if (StringUtils.isNotBlank(info4)) {
            String str = info4;
            String str2 = str.substring(1, str.length() - 1);
            // "System.out.println("切割 str:" +  str3);"
            /* --------------------------------数组转换完成------------------------------ */
            String[] arr = str2.split(","); // 用,分割
            // System.out.println("arr:" + arr);
            Double xValue = 0.00d;
            Double yValue = 0.00d;
            for (int i = 0; i < arr.length; i++) {
                String strip = StringUtils.strip(arr[i], "[]");
                System.out.println("i:" + i);
                // 判断奇偶数
                if ((i & 1) == 1) {
                    System.out.println("奇数-> Y轴：" + strip );
                    yValue = yValue + Double.parseDouble(strip);
                } else {
                    System.out.println("偶数-> X轴：" + strip );
                    xValue = xValue + Double.parseDouble(strip);
                }
            }
            Integer denominator = arr.length / 2;
            Double lng = ( xValue / denominator );
            Double lat = ( yValue / denominator );
            map.put("lng", lng.toString());
            map.put("lat", lat.toString());
            map.put("height", "0");
            System.out.println(map);
        }
    }



}
