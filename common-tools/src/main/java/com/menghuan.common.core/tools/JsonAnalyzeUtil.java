package com.menghuan.common.core.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: DZL
 * @Date: 2019/11/25
 * @Description: json动态解析工具类
 */
public class JsonAnalyzeUtil {

    static Map<String,String> map=new HashMap<>();

    /**
     * @Description: 将json字符串解析为map
     * @Auther: 曾泽亦
     */
    public static Map<String,String> parseJsonString(String json, List<String> list) {
        LinkedHashMap<String, Object> jsonMap = JSON.parseObject(json, new TypeReference<LinkedHashMap<String, Object>>() {});
        // 推荐该方法遍历Map，尤其是容量大时
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            // 调用解析Json的方法
            parseJsonMap(entry,list);
        }
        return map;
    }


    /**
     * @Description: map按动态的key解析值
     * @Auther: dzl
     * parse 解析
     */
    public static void parseJsonMap(Map.Entry<String, Object> entry,List<String> list) {
        System.out.println(entry.getKey() + ":" + entry.getValue());

        // 如果是单个map继续遍历
        if (entry.getValue() instanceof Map) {
            LinkedHashMap<String, Object> jsonMap = JSON.parseObject(entry.getValue().toString(), new TypeReference<LinkedHashMap<String, Object>>() {

            });
            for (Map.Entry<String, Object> entry2 : jsonMap.entrySet()) {
                parseJsonMap(entry2,list);
            }
        }

        // 如果是list就提取出来
        if (entry.getValue() instanceof List) {
            List list2 = (List) entry.getValue();
            for (int i = 0; i < list2.size(); i++) {
                System.out.println(list2.get(i));
                //如何还有，循环提取
                parseJsonString(list2.get(i).toString(),list);
            }
        }

        // 如果是String就获取它的值
        if (entry.getValue() instanceof String) {
            for (String s:list) {
                if (s.equals(entry.getKey())){
                    String value = (String) entry.getValue();
                    map.put(s,value);
                }
            }
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 如果是int就获取它的值
        if (entry.getValue() instanceof Integer) {
            for (String s:list) {
                if (s.equals(entry.getKey())){
                    String value = String.valueOf(entry.getValue());
                    map.put(s,value);
                }
            }
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}
