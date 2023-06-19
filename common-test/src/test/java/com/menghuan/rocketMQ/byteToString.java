package com.menghuan.rocketMQ;

import java.io.UnsupportedEncodingException;

/**
 * @Author: menghuan
 * @Date: 2022/10/12 10:39
 */
public class byteToString {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // String str = "[76, 73, 78, 75, 83, 65, 77, 69, 45, 50, 48, 50, 50, 46, 49, 48, 46, 49, 49]";
        // Byte[] str = [76, 73, 78, 75, 83, 65, 77, 69, 45, 50, 48, 50, 50, 46, 49, 48, 46, 49, 49];

        // byte[] bytes = {76, 73, 78, 75, 83, 65, 77, 69, 45, 50, 48, 50, 50, 46, 49, 48, 46, 49, 49};
        byte[] bytes = {76, 73, 78, 75, 83, 65, 77, 69, 45, 50, 48, 50, 50, 46, 49, 48, 46, 49, 50, 32, -28, -72, -128, -26, -105, -91, -28, -71, -117, -24, -82, -95, -27, -100, -88, -28, -70, -114, -26, -103, -88};
        String s = new String(bytes,"UTF-8");
        System.out.println(
                "s:" + s
        );
    }

}
