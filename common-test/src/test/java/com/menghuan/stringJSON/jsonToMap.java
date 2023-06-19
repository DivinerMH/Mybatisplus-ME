package com.menghuan.stringJSON;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;

import static com.menghuan.stringJSON.jsonToMap.getMapForJson;

/**
 * @Author: menghuan
 * @Date: 2022/9/28 10:37
 */
@Slf4j
public class jsonToMap {

    private static JSONArray jsonArray;
    private static Iterator<Object> iterator;
    private static Map.Entry maps1;
    private static String value;
    private static Map map;
    
    public static void getMapForJson(String jsonStr){
        map = (Map) JSON.parse(jsonStr);

        for (Object maps : map.entrySet()){
            maps1 = (Map.Entry) maps;
            if (maps1 != null && maps1.getValue() != null){
                value = maps1.getValue().toString();
                if (value.contains("{") && value.contains("}")){
                    if (value.startsWith("[") && value.endsWith("]")){
                        log.info("MainActivity", "数组");
                        jsonArray = JSONArray.parseArray(value);
                        iterator = jsonArray.iterator();
                        while (iterator.hasNext()){
                            getMapForJson(iterator.next().toString());
                        }
                    }else {
                        log.info("MainActivity", "对象");
                        getMapForJson(value);
                    }
                }else {
                    log.info("key" + "maps1.getKey():" + maps1.getKey());
                    log.info("value" + "maps1.getValue():" + maps1.getValue());
                }
            }
        }
        System.out.println(maps1);
    }

    @Test
    public void xxxTest() {
        String json = "{\"data\":[{\"2019-04-25\":0},{\"2019-04-24\":1},{\"2019-04-23\":0}," +
                "{\"2019-04-22\":4},{\"2019-04-21\":2},{\"2019-04-20\":0}," +
                "{\"2019-04-19\":2},{\"2019-04-18\":0},{\"2019-04-17\":0}]}";
        getMapForJson(json);
    }

    Map<String,String> resultMap;
    Map<String,String> resultMapTwo;

    @Test
    public void xxxTest2() {
        String armString = "appKey=1664244347446&bizContent={\"tenantId\": 418}&methodUrl=/org-type/lists/conditions";
        String str = armString.replaceAll("&" ,  "\",\"");
        String strOne = str.replaceAll("=", "\":\"");
        System.out.println("strOne:" + strOne);
        String strTwo = "{\"" + strOne + "\"}";
        System.out.println("strTwo:" + strTwo);
        // resultMap = JSONObject.parseObject(strTwo, Map.class);
    }

    @Test
    public void xxxTest3() {
        String armString = "appKey=1664244347446&bizContent={\"tenantId\": 418}&methodUrl=/org-type/lists/conditions";
        String str = armString.replaceAll("&" ,  "\",\"");
        String strOne = str.replaceAll("=", "\":\"");
        System.out.println("strOne:" + strOne);
        int biz = strOne.indexOf("bizContent");
        String strThree = strOne.substring(0, biz);
        System.out.println("strThree:" + strThree);

        String strFour = strOne.substring(strOne.lastIndexOf("methodUrl"));
        System.out.println("strFour:" + strFour);

        String strTwo = "{\"" + strOne + "\"}";
        System.out.println("strTwo:" + strTwo);
        // resultMap = JSONObject.parseObject(strTwo, Map.class);

        String strFive = strThree + strFour;
        System.out.println("strFive:" + strFive);


        resultMap = JSONObject.parseObject("{\"" + strFive + "\"}", Map.class);
        System.out.println(resultMap.toString());


        String strSix = strOne.substring(strOne.indexOf("\"bizContent"), strOne.lastIndexOf(",\"methodUrl"));
        System.out.println("strSix:" + strSix);
        String strSeven = strSix.substring(strSix.lastIndexOf("{\"tenantId"), strSix.length() - 1);
        System.out.println("strSeven:" + strSeven);
        // resultMapTwo = JSONObject.parseObject("{\"" + strSix + "\"}", Map.class);
        // System.out.println(resultMapTwo.toString());
        resultMap.put("bizContent",strSeven);
        System.out.println(resultMap.toString());
    }

    @Test
    public void xxxTest4() {
        String armString = "appKey=1664244347446&bizContent={\"tenantId\": 418}&methodUrl=/org-type/lists/conditions";
        if (armString.contains("bizContent")){
            String str = armString.replaceAll("&" ,  "\",\"");
            String strOne = str.replaceAll("=", "\":\"");
            System.out.println("strOne:" + strOne);

            // String strTwo = "{\"" + strOne + "\"}";
            // System.out.println("strTwo:" + strTwo);
            // resultMap = JSONObject.parseObject(strTwo, Map.class);

            String strThree = strOne.substring(0, strOne.indexOf("bizContent"));
            System.out.println("strThree:" + strThree);

            // String strFour = strOne.substring(strOne.lastIndexOf("methodUrl"));
            String strFour = strOne.substring(strOne.lastIndexOf("}") + 4);
            System.out.println("strFour:" + strFour);

            // String strFive = strThree + strFour;
            // System.out.println("strFive:" + strFive);

            resultMap = JSONObject.parseObject("{\"" + strThree + strFour + "\"}", Map.class);
            System.out.println("=================================================================");
            System.out.println("resultMap:" + resultMap.toString());


            String strSix = strOne.substring(strOne.indexOf("\"bizContent"), strOne.lastIndexOf("}") + 4);
            System.out.println("strSix:" + strSix);
            String strSeven = strSix.substring(strSix.lastIndexOf("{\"tenantId"), strSix.length() - 3);
            System.out.println("strSeven:" + strSeven);
            // resultMapTwo = JSONObject.parseObject("{\"" + strSix + "\"}", Map.class);
            // System.out.println(resultMapTwo.toString());
            String strEight = strSix.substring(strSix.lastIndexOf("bizContent") + 13, strSix.length() - 3);
            System.out.println("strEight:" + strEight);


            // resultMap.put("bizContent", strSeven);

            System.out.println(resultMap.toString());
        }
        if (!armString.contains("bizContent")){
            System.out.println("==========================");
        }


    }


}
