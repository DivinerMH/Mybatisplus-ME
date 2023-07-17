package com.menghuan.stringJSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import lombok.Data;

/**
 * @Author: menghuan
 * @Date: 2022/7/13 9:53
 */
public class listToJSONArray {

    @Test
    public void testListToJSONArray() {
        List<Map<String, String>> mapList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("id", Integer.valueOf(i).toString());
            map.put("name", "KK" + i);
            mapList.add(map);
        }
        // System.out.println(mapList);

        // JSONArray jsonArray = JSONArray.parseArray(mapList.toString());
        // List<Student> students = jsonArray.toJavaList(Student.class);

        // List<Student> students = ObjectCopyUtils.copy(mapList, Student.class);

        String s = JSON.toJSONString(mapList);
        List<Student> students = JSON.parseArray(s, Student.class);

        System.out.println(students);
    }
}

@Data
class Student {
    private Integer id;
    private String name;
}