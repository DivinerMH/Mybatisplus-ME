package com.hanchan.codeTest_2021_03;

import org.junit.Test;

import java.util.*;

/**
 * @Author: menghuan
 * @Date: 2021/3/3 16:00
 *
 * 任给一个数组，其中只有一个元素是单独出现，其他是成对出现，输出单独的元素。
 * 例如： 输入： {2，2，1，1，4，4，7}
 * 输出：7
 */
public class dataExtraction {

    @Test
    public void dataExtractionOne(){
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] splitArray = next.split(",");
        List<String> strList = Arrays.asList(splitArray);
        System.out.println("splitArray" + strList.toString());

        for (int m = 0; m < strList.size(); m++) {
            // 默认所有数都是为唯一数，count标识为0
            int count = 0;
            for (int n = 0; n < strList.size(); n++) {
                // 1、排除自己与自己相等 + 还存在相等则是重复数据 -> 添加判断标识
                if (!(m == n) && strList.get(m).equals(strList.get(n))){
                    count++;
                }
            }
            if( count == 0){
                System.out.println("唯一数：" + strList.get(m));
                return;
            }
        }
    }

    @Test
    public void dataExtractionTwo(){
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] splitArray = next.split(",");
        List<String> strListOne = Arrays.asList(splitArray);
        HashSet<String> setList = new HashSet<>(strListOne);
        ArrayList<String> stringsTwo = new ArrayList<>(setList);
        System.out.println("strListOne" + strListOne.toString());
        System.out.println("stringsTwo" + stringsTwo.toString());

        for (int m = 0; m < stringsTwo.size(); m++) {
            for (int n = 0; n < strListOne.size(); n++) {
                // 1、排除自己与自己相等 2、直接跳过存在与非己相等
                if (stringsTwo.get(m) == strListOne.get(n) || m == n){
                    continue;
                }else{
                    System.out.println("唯一数：" + stringsTwo.get(m));
                    return;
                }
            }
        }
    }


}
