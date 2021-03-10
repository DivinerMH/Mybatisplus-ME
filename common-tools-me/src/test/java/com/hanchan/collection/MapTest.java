package com.hanchan.collection;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Author:menghuan
 * @Date:2020/8/19 11:17
 * @Description map 判空
 */
public class MapTest {

    @Test
    public void test1() {
        HashMap<Object, Object> map = new HashMap<>(64);
        map.put(null, null);
        //map = null;
        //System.out.println(null == map);
        if (null == map) {
            System.out.println("测试1：map为空");
        } else {
            System.out.println("测试1：map不为空");
        }
        if (map.size() <= 0) {
            System.out.println("测试2：map为空");
        } else {
            System.out.println("测试2：map不为空");
        }
        // map.clear();
        if (map.isEmpty()) {
            System.out.println("测试3：map为空");
        } else {
            System.out.println("测试3：map不为空");
        }
        if (map.containsKey(null)) {
            System.out.println("测试4：map包含该键值对");
        } else {
            System.out.println("测试4：map不包含该键值对");
        }
    }
}
