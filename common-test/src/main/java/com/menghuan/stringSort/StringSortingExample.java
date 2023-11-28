package com.menghuan.stringSort;

import java.util.Arrays;

public class StringSortingExample {

    public static void main(String[] args) {
        String[] strings = {"abc", "ABC", "aBc", "中文编码"};

        Arrays.sort(strings);

        for (String str : strings) {
            System.out.println(str);
        }
    }

}
