package com.hanchan.codeTest_2020_11;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author:menghuan
 * @Date:2020/12/8 11:41
 */
public class GrovyTest {

    /*@Test
    public void deleteString(){
        int vv[] = {1,2};

        String dd = null;

        try {
            dd =   Float.intBitsToFloat(Integer.parseInt(vv));
        } catch (Exception e) {
            dd = Double.longBitsToDouble(Long.parseLong(vv));
        }
        System.out.println(dd);
    }*/

    @Test
    public void deleteString2(){
        String vv[] = {"1","22"};

        String dd = null;

        String a = vv[0];
        String b = vv[1];

        try {
            // 返回对应于给定位表示形式的 float 值。根据 IEEE 754 浮点“单一格式”位布局，该参数被视为浮点值表示形式。
            // float varAB = Float.intBitsToFloat(Integer.parseInt(a)) + Float.intBitsToFloat(Integer.parseInt(b));
            double varAB = Long.parseLong(a) + Long.parseLong(b);
            dd = varAB + "";
        } catch (Exception e) {

            float varAB = Float.parseFloat(a) + Float.parseFloat(b);
            dd = varAB + "";
        }
        System.out.println(dd);
    }

    @Test
    public void deleteString3(){
        String var = "111,25,333,444,777";
        String vv[] = var.split(",");
//        String vv[] = {var};
        String a;
        String b;

        String dd = null;

        a = vv[0];
        b = vv[1];

        try {
            Double varValue = Double.parseDouble(a) + Double.parseDouble(b);
            dd = varValue.toString();
            System.out.println("执行正确的Code");
        } catch (Exception e) {
            Float varValue = Float.parseFloat(a) + Float.parseFloat(b);
            dd = varValue.toString();
        }
        System.out.println(dd);
    }

}
