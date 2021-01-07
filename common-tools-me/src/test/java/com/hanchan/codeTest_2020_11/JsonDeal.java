package com.hanchan.codeTest_2020_11;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:menghuan
 * @Date:2020/12/16 15:49
 */
public class JsonDeal {

    static {
        Map<String, Object> temporaryMap = new HashMap<>();
        temporaryMap.put("configId", 1);
        temporaryMap.put("ruleType", 2);
        temporaryMap.put("ruleId", 3);
    }

    @Test
    public void xxxTest() {
        // String json = new String();
        String json = "{\u2028    \"configId\": 399,\n" +
                "    \"ruleType\": \"0\",\n" +
                "    \"ruleId\": 399,\n" +
                "}，\n" +
                "{\u2028    \"configId\": 399,\n" +
                "    \"ruleType\": \"0\",\n" +
                "    \"ruleId\": 399,\n" +
                "}";
        JSONArray objects = JSON.parseArray(json);
        System.out.println(objects);
    }

    @Test
    public void xxxTest2() {
        // String json = new String();
        String json = "[{\n" +
                "\t\t\"configId\": 322,\n" +
                "\t\t\"ruleType\": \"1\",\n" +
                "\t\t\"ruleId\": 1000\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"configId\": 42,\n" +
                "\t\t\"ruleType\": \"1\",\n" +
                "\t\t\"ruleId\": 2222\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"configId\": 399,\n" +
                "\t\t\"ruleType\": \"0\",\n" +
                "\t\t\"ruleId\": 399\n" +
                "\t}\n" +
                "]";
        JSONArray objects = JSON.parseArray(json);
        System.out.println(objects);
        for (Object object : objects) {
            System.out.println("object" + object);
        }
    }

    @Test
    public void xxxTest3() {
        // String json = new String();
        String json = "[{\n" +
                "\t\t\"configId\": 322,\n" +
                "\t\t\"ruleType\": \"1\",\n" +
                "\t\t\"ruleId\": 1000\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"configId\": 42,\n" +
                "\t\t\"ruleType\": \"1\",\n" +
                "\t\t\"ruleId\": 2222\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"configId\": 399,\n" +
                "\t\t\"ruleType\": \"0\",\n" +
                "\t\t\"ruleId\": 399\n" +
                "\t}\n" +
                "]";
        JSONArray objects = JSON.parseArray(json);
        List<TemporaryEntity> temporaryEntities = objects.toJavaList(TemporaryEntity.class);
        // System.out.println("temporaryEntities:" + temporaryEntities);
        for (TemporaryEntity temporaryEntity : temporaryEntities) {
            System.out.println("temporaryEntity:" + temporaryEntity);
        }
    }


}
