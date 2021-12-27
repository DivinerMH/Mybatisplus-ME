package com.test_I.codeTest_2021_11;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: menghuan
 * @Date: 2021/11/18 9:49
 */
public class CopyShallow {

    public static void main(String[] args) {
        // 赋值操作：=只能实现浅拷贝，map中的内容发生变化，copyMap中的内容亦同步发生变化
        Map map = new HashMap(1);
        map.put("name", "Tom");

        System.out.println("初始化 map:" + map);


        // 实现浅拷贝的方式：使用=
        Map copyMap = new HashMap(1);
        copyMap = map;
        map.remove("name");

        System.out.println("移除后 map:" + map);
        System.out.print("copyMap:" + copyMap);

        // 实现深拷贝：使用Map.putAll()
        /*Map putAllMap = new HashMap(1);
        putAllMap.putAll(map);
        map.remove("name");
        System.out.println("移除后 map:" + map);
        System.out.print("putAllMap:" + putAllMap);*/

    }

}
