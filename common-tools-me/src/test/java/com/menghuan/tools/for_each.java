package com.menghuan.tools;

import java.util.UUID;

/**
 * @Author:menghuan
 * @Date:2019/12/9 11:05
 */
public class for_each {


    public static void main(String[] args) {
        String[] id = new String[10002];
        for (int i = 0; i < 10000; i++) {
            //截取最后一部分
            id[i] = UUID.randomUUID().toString().substring(24);
        }
        System.out.println(id.length);
        System.out.println("第一个:" + id[0]);

        for (int j = 0; j < 10000; j++) {
            for (int i = 0; i < 10000 && i != j; i++) {
                if (id[j].equals(id[i]))
                    System.out.println(id[j]);
            }
        }

        System.out.println("最后一个：" + id[9999]);
    }

}
