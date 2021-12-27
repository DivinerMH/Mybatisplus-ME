package com.test_I.codeTest_2021_11;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: menghuan
 * @Date: 2021/11/18 9:50
 */
public class CopyDeep{

    @Test
    public void mapDeepCopy(){
        Map<String, String> map = new HashMap<String, String>(1);
        map.put("name", "Tom");

        System.out.println("初始化 map:" + map);


        // 实现深拷贝：使用Map.putAll()
        Map<String, String> putAllMap = new HashMap<String, String>(1);
        putAllMap.putAll(map);
        map.remove("name");

        System.out.println("移除后 map:" + map);
        System.out.print("putAllMap:" + putAllMap);
    }


    @Test
    public void hashMapDeepCopy(){
        HashMap<String,String> hashMap = new HashMap<String,String>(1);
        hashMap.put("name", "Tom");

        System.out.println("初始化 hashMap:" + hashMap);

        // 实现深拷贝：使用HashMap.putAll()
        HashMap<String,String> putAllHashMap = new HashMap<String,String>(1);
        putAllHashMap.putAll(hashMap);
        hashMap.remove("name");

        System.out.println("移除后 hashMap:" + hashMap);
        System.out.print("putAllHashMap:" + putAllHashMap);
    }

}
