package com.test_I.codeTest_2023_04;


/**
 * 题目描述：小明负责维护项目下的代码，需要查找出重复代码，用以支撑后续的代码优化，请你帮助小明找出重复的代码，。
 * 重复代码查找方法：以字符串形式给定两行代码（字符串长度 1<length<= 100,由英文字母、数字和空格组成），找出两行代码中的最长公共子串。
 * 注：如果不存在公共子串，返回空字符串
 */
public class Check {

    /*public static void main(String[] args) {
        String strI = "hello123world";
        String strII = "hello123abc4";
        String maxStr = strI.length() > strII.length() ? strI : strII;
        String minStr = strI.length() > strII.length() ? strII : strI;
        // System.out.println(maxStr);

        String arm = "";

        for (int i = 0; i < minStr.length(); i++) {
            for (int j = i + 1; j < minStr.length(); j++) {
                String substring = minStr.substring(i, j);
                boolean contains = maxStr.contains(substring);
                if (contains && substring.length() > arm.length()) {
                    arm = substring;
                }
            }
        }
        System.out.println(arm);

    }*/

    public static void main(String[] args) {
        String strI = "hello123world";
        String strII = "hello123abc4";
        String maxStr = strI.length() > strII.length() ? strI : strII;
        String minStr = strI.length() > strII.length() ? strII : strI;
        // System.out.println(maxStr);

        String arm = "";

        for (int i = 0; i < minStr.length(); i++) {
            char c = strI.charAt(i);
            if (maxStr.contains(String.valueOf(c))){
                // arm =
            }
        }
        System.out.println(arm);

    }
}
