package com.menghuan.tools;

import org.junit.Test;

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
}
