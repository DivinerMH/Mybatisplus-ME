package com.menghuan.generator.tools;

import org.junit.Test;

import static com.menghuan.common.core.tools.ByteUtils.ExistChar;

/**
 * @Author:menghuan
 * @Date:2020/8/21 11:09
 */
public class change {

    @Test
    public void tset1() {
        String str = "11112aaaa";
        // 判断字符串中是否只包含字母，只包含字母，返回true，否则返回false
        boolean b = ExistChar(str);
        System.out.println(b);
    }

    @Test
    public void tset2() {
        String str = "0123456789ABCDEF";
        boolean flag = true;
        String name = "Java旅途";

        if (flag) {

        }

        if (!flag) {

        }

        if (name == null) {

        }

        if (name != null) {

        }

        switch (name) {

        }
    }



}

