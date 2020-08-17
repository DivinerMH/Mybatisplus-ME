package com.menghuan.tools;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * @Author:menghuan
 * @Date:2020/6/12 11:26
 */
public class StringTransform {

    @Test
    public void StringTransform(){

        String s= "test200611/gougu 18101501.png";
        String replace1 = s.replace("/", "-");
        System.out.println(replace1);
        String replace2 = s.replace("test", "learn");
        System.out.println(replace2);
        String replace3 = replace1.replace("test", "study");
        System.out.println(replace3);

    }

    /** 字符串切割 */
    @Test
    public void StringCut(){

        String str = "[[114.27459803363885,30.56454085579769],[114.27748159432588,30.563475811515477]]";
        String str2 = str.substring(str.indexOf("[") + 1);
        String str4 = str2.substring(0, str2.length() - 1);
        System.out.println("切割 str:" +  str4);
        /** -------------------------数组转换完成----------------------- */
        String[] arr = str4.split(","); // 用,分割
        String s = arr[0] + "," + arr[1];

        System.out.println(s);
    }

    /** 字符串切割 */
    @Test
    public void StringCut2(){

        String str = "[[114.27459803363885,30.56454085579769],[114.27748159432588,30.563475811515477]]";
        String str2 = str.substring(1, str.length() - 1);
        System.out.println("切割 str:" +  str2);
        /** -------------------------数组转换完成----------------------- */
        /*char ss[] = str2.toCharArray();//利用toCharArray方法转换
        System.out.println(ss[0]);*/
        String[] arr = str2.split(","); // 用,分割
        String s = arr[0] + "," + arr[1];
        System.out.println(s);

    }

    /** 字符串切割 */
    @Test
    public void StringCut3(){
        String str = "-0-2-3-5-";
        String str2 = str.substring(1, str.length() - 1);
        System.out.println("切割 str:" +  str2);
        String[] arr = str2.split("-"); // 用-分割
        String string = Arrays.toString(arr);
        System.out.println("string:" + string);

        ArrayList<Integer> intList = new ArrayList<>();
        for (String s : arr) {
            int i = Integer.parseInt(s);
            intList.add(i);
            intList.add(i);
        }

        System.out.println("intList:" + intList);





        List<String> strings = Arrays.asList(string);

        System.out.println("strings:" + strings);
    }

    /** 字符串切割 */
    @Test
    public void StringCut4(){
        String str = "-0-2-3-5-";
        String[] arr = str.split("-"); // 用,分割
        System.out.println(arr);
        String string = Arrays.toString(arr);
        System.out.println(string);
    }


    /** 数组转字符串 - 20.06.30 */
    @Test
    public void ArrayToString(){
        String[] arr = { "0", "1", "2", "3", "4", "5" };
        //数组转字符串 org.apache.commons.lang3.StringUtils
        String str3 = StringUtils.join(arr); // 数组转字符串,其实使用的也是遍历
        System.out.println(str3); // 012345
        String str4 = StringUtils.join(arr, ","); // 数组转字符串(逗号分隔)(推荐)
        System.out.println(str4); // 0,1,2,3,4,5
    }

    /** 数组转字符串 - 20.06.30 */
    @Test
    public void ArrayToString2(){
        String[] arr = { "0", "1", "2", "3", "4", "5" };
        // 数组转字符串 org.apache.commons.lang3.ArrayUtils
        String str2 = ArrayUtils.toString(arr, ","); // 数组转字符串(逗号分隔,首尾加大括号)
        System.out.println(str2); // {0,1,2,3,4,5}
    }


    /** 字符串切割 */
    @Test
    public void StringCut7(){
        String str = "-0-2-3-5-";
        String str2 = str.substring(1, str.length() - 1);
        System.out.println("切割 str:" +  str2);
        String[] arr = str2.split("-"); // 用-分割
        String string = Arrays.toString(arr);
        System.out.println("string:" + string);

        Set set = new HashSet();
        for (String s : arr) {
            int i = Integer.parseInt(s);
            set.add(i);
            set.add(i);
            set.add(44);
        }




        List<String> strings = Arrays.asList(string);

        set.addAll(strings);
        System.out.println("set:" + set);

        System.out.println("strings:" + strings);
    }



}
