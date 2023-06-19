package com.menghuan.stringToMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @Author: menghuan
 * @Date: 2022/9/22 15:35
 */
public class stringToMap {

    @Test
    public void sss(){
        String str =  "appKey=1663643339413&methodUrl=/org-type/lists";
        String str2 = str.replaceAll("&" ,  "\",\"");
        System.out.println(str2);

        String str3 = str2.replaceAll("=", "\":\"");
        System.out.println(str3);

        StringJoiner stringJoiner = new StringJoiner("", "{\"", "\"}");
        StringJoiner str4 = stringJoiner.add(str3);
        System.out.println(str4);

        /*JSONObject jsonObject = JSONObject.parseObject(str3);
        System.out.println(jsonObject.toString());*/

        Map<String,String> map = JSONObject.parseObject(String.valueOf(str4), Map.class);
        System.out.println(map);
    }

    @Test
    public void sss2(){
        JSONObject zhangsan = new JSONObject();
        try {
            //添加
            zhangsan.put("name", "张三");
            zhangsan.put("age", 18.4);
            zhangsan.put("birthday", "1900-20-03");
            zhangsan.put("majar", new String[] {"哈哈","嘿嘿"});
            zhangsan.put("null", null);
            zhangsan.put("house", false);
            System.out.println(zhangsan.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sss3(){
        Map<String, String> mapParams = new HashMap<>();

        String str =  "appkey=1663643339413&method_url=/org-type/lists";
        String str2 = str.replaceAll("&", ",");
        String result = "{" + str2 + "}";
        System.out.println(result);

        JSONObject jsonObject = JSON.parseObject(result);
        Map map = jsonObject.toJavaObject(jsonObject, Map.class);


        // mapParams =  (Map) JSON.parse(result);

        System.out.println(map);

    }

}
