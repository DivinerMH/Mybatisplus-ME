package com.test.codeTest_2020_11;

import java.math.BigDecimal;

/**
 * @Author: menghuan
 * @Date: 2021/2/3 9:50
 */
public class FloatAndDouble {

    public static void main(String[] args) {

        test1();
        System.out.println("------------------BigDecimal不当也有精度丢失的情况，如double的构造方法------------------");
        test2();
        System.out.println("--------------------金额运算尽量使用 BigDecimal(String val)进行运算--------------------");
        test3();
    }

    private static void test1() {

        double totalAmount = 0.09;

        double feeAmount = 0.02;

        double tradeAmount = totalAmount - feeAmount;

        System.out.println(tradeAmount);

    }

    /**
     * BigDecimal(double val) 精度丢失问题
     * BigDecimal(String val) 推荐 ( 所以，一定要使用String的构造方法 )
     */
    private static void test2() {

        double totalAmount = 0.09;

        double feeAmount = 0.02;

        BigDecimal tradeAmount = new BigDecimal(totalAmount).subtract(new BigDecimal(feeAmount));

        System.out.println(tradeAmount);

    }

    /**
     * 金额运算尽量使用 BigDecimal(String val)进行运算
     */
    private static void test3() {

        double totalAmount = 0.09;

        double feeAmount = 0.02;

        BigDecimal tradeAmount = new BigDecimal(String.valueOf(totalAmount)).subtract(new BigDecimal(String.valueOf(feeAmount)));

        System.out.println(tradeAmount);

    }

}
