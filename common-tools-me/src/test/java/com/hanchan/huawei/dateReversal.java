package com.hanchan.huawei;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Author: menghuan
 * @Date: 2021/3/3 14:55
 * https://blog.csdn.net/cv_yuippe/article/details/39431669
 *
 * 输入2个数字，反转数字相加，如果一个为8，另一个为210,210反转要出去0即12
 *
 * 稍微复杂点，输入两个字符串，将两个字符串反转后，在转换为整型，即可。
 *      其210反转即012，变整型后自动将前面0给忽略了
 */
public class dateReversal {

    @Test
    public void dateReversalOne(){
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        System.out.println( str1 + "-" + str2);

        String nstr1 = new StringBuffer(str1).reverse().toString();
        String nstr2 = new StringBuffer(str2).reverse().toString();

        // 其210反转即012，变整型后自动将前面0给忽略了
        int IntStr1 = Integer.parseInt(nstr1);
        int IntStr2 = Integer.parseInt(nstr2);

        System.out.print(IntStr1 + IntStr2);

    }
}
