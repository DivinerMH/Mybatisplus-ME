package com.hanchan.codeTest_2020_07;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.junit.Test;

import java.util.HashMap;

/**
 * @Author:menghuan
 * @Date:2020/11/11 10:53
 */
public class ArrayDeal {

    public static void main(String[] args) {

    }

    @Test
    public void dealGisMap() {
        HashMap<String, String> map = new HashMap<>(8);

        String info = "[1,2]";
        String info2 = "[[1,2]]";
        String info3 = "[[11,22],[55,77]]";
        if (StringUtils.isNotBlank(info3)) {
            String str = info2;
            String str2 = str.substring(1, str.length() - 1);
            // "System.out.println("切割 str:" +  str3);"
            /* --------------------------------数组转换完成------------------------------ */
            String[] arr = str2.split(","); // 用,分割
            if(arr.length > 1){
                // "String s = arr[0] + "," + arr[1];"
                map.put("lng", arr[0].substring(1));
                map.put("lat", arr[1].substring(0, arr[1].lastIndexOf("]")));
                System.out.println(map);
            }
        }
        System.out.println(map);
    }
}
