package com.menghuan.stringJSON;

import org.junit.Test;

/**
 * @Description Java删除字符串中的指定字符
 * @Author: menghuan
 * @Date: 2020/11/23 14:45
 */
public class DealString {

    @Test
    public void deleteString() {
        String test = ("chaojimali");
        System.out.println("转换前：" + test);
        test = test.replace("chaoji", "");
        System.out.println("转换后：" + test);
    }

    @Test
    public void deleteString2() {
        String test = ("chaojimalichaoji");
        System.out.println("转换前：" + test);
        test = test.replace("chaoji", "");
        System.out.println("转换后：" + test);
    }

    @Test
    public void deleteString3() {
        String test = ("chaojimalichaoji");
        System.out.println("转换前：" + test);
        StringBuilder strBuilder = new StringBuilder(test);
        StringBuilder replace = strBuilder.replace(6, 10, "hundouluo");
        System.out.println("转换后：" + replace);

    }

    /**
     * 截取函数
     */
    @Test
    public void deleteString4() {
        String test = ("chaojimalichaoji");
        System.out.println("转换前：" + test);
        test = test.substring(5, 12);
        System.out.println("转换后：" + test);
    }


}
