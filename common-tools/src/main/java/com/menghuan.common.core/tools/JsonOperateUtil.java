package com.menghuan.common.core.tools;

import cn.hutool.extra.template.TemplateException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

import com.menghuan.common.core.constant.enums.BusinessEnum;
import org.apache.commons.lang3.StringUtils;


import java.util.*;

/*
 *  @Author: yf
 *  @Description:   JSON合并
 *  @Date: 2019/11/27 10:04
 */
public class JsonOperateUtil {

    //临时接收字符串
    private static String str = "";

    //最底层key容器(无序,去重集合)
    private static Set<String> setList =  new HashSet<>();

    /**
     * 动态替换定义名称 ---- key值
     * @param json      原json对象
     * @param map       新key的map
     * @return          替换key后的json字符串
     */
    public static String changeJsonByKey(JSONObject json, Map<String, String> map){
        JSONObject obj = changeJsonObj(json, map);

        return obj.toJSONString();
    }

    public static JSONObject changeJsonObj(JSONObject jsonObj,Map<String, String> keyMap) {
        JSONObject resJson = new JSONObject();
        Set<String> keySet = jsonObj.keySet();
        for (String key : keySet) {
            String resKey = keyMap.get(key) == null ? key : keyMap.get(key);
            try {
                JSONObject jsonobj1 = jsonObj.getJSONObject(key);
                resJson.put(resKey, changeJsonObj(jsonobj1, keyMap));
            } catch (Exception e) {
                try {
                    JSONArray jsonArr = jsonObj.getJSONArray(key);
                    resJson.put(resKey, changeJsonArr(jsonArr, keyMap));
                } catch (Exception x) {
                    resJson.put(resKey, jsonObj.get(key));
                }
            }
        }
        return resJson;
    }

    public static JSONArray changeJsonArr(JSONArray jsonArr,Map<String, String> keyMap) {
        JSONArray resJson = new JSONArray();
        for (int i = 0; i < jsonArr.size(); i++) {
            JSONObject jsonObj = jsonArr.getJSONObject(i);
            resJson.add(changeJsonObj(jsonObj, keyMap));
        }
        return resJson;
    }

    /**
     * 解析json中组件定义名称
     * @param json      json字符串
     * @return          定义名称---key
     */
    public static String parseKeyByTest(String json){
        JSONObject obj = JSON.parseObject(json);
        StringBuffer sb = JsonOperateUtil.getAllKey(obj);
        Set<String> s = new HashSet<>();
        String[] arr = sb.toString().split(",");
        for(String a : arr){
            if(a.contains("test")){
                s.add(a);
            }
        }

        //返回值数量大于1 时不处理
        if(s.size() > 1){
            throw new TemplateException(BusinessEnum.JSON_PARSE_BY_KEY.getDescription());
        }

        return s.iterator().next();
    }

    /**
     * 递归遍历获取所有key值
     * @param obj       json对象
     * @return
     */
    public static StringBuffer getAllKey(JSONObject obj){
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> keys = obj.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            stringBuffer.append(key.toString()).append(",");
            if (obj.get(key) instanceof JSONObject) {
                JSONObject innerObject = (JSONObject) obj.get(key);
                stringBuffer.append(getAllKey(innerObject));
            } else if (obj.get(key) instanceof JSONArray) {
                JSONArray innerObject = (JSONArray) obj.get(key);
                stringBuffer.append(getAllKey(innerObject));
            }
        }
        return stringBuffer;
    }

    /**
     * 递归遍历获取所有key值
     * @param obj       json数组
     * @return
     */
    public static StringBuffer getAllKey(JSONArray obj) {
        StringBuffer stringBuffer = new StringBuffer();
        if (obj != null ) {
            Iterator i1 = obj.iterator();
            while (i1.hasNext()) {
                Object key = i1.next();
                if (key instanceof  JSONObject) {
                    JSONObject innerObject = (JSONObject) key;
                    stringBuffer.append(getAllKey(innerObject));
                } else if (key instanceof JSONArray) {
                    JSONArray innerObject = (JSONArray) key;
                    stringBuffer.append(getAllKey(innerObject));
                }else{
                }
            }
        }
        return stringBuffer;
    }

    /**
     * 解析json字符串,获取最底层所有key
     * @param json      json字符串
     * @return
     */
    public static Set<String> parseJsonKey(String json){
        LinkedHashMap<String, Object> jsonMap = JSON.parseObject(json, new TypeReference<LinkedHashMap<String, Object>>() {});
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            parseJsonMap(entry);
        }

        return setList;
    }

    //解析获取
    public static void parseJsonMap(Map.Entry<String, Object> entry){

        //如果是单个map继续递归遍历
        if(entry.getValue() instanceof Map){
            LinkedHashMap<String, Object> jsonMap = JSON.parseObject(entry.getValue().toString(), new TypeReference<LinkedHashMap<String, Object>>() {});
            for (Map.Entry<String, Object> entry2 : jsonMap.entrySet()) {
                parseJsonMap(entry2);
            }
        }

        //如果是String或者list就获取key
        if(entry.getValue() instanceof String || entry.getValue() instanceof List){
            setList.add(entry.getKey());
        }
    }

    /**
     * TF文件的json数据合并 ---- 合并resource部分
     *             多份json中只允许有一份主json,包含完整子节点(provider,resource,output,variable)
     *             副json只包含resource部分
     * @param jsonList  json数据的集合
     * @return          合并完成后的数据
     * merge 合并
     */
    public static JSONObject mergeJson(List<String> jsonList){

        // 定义返回JSON
        // JSONObject ==> json对象，就是一个键对应一个值(键值对)，使用的是大括号{ }，如：{key:value}
        JSONObject result = new JSONObject(true);

        try {
            //  JSONArray ==> json数组，使用中括号[ ],只不过数组里面的项也是json键值对格式的
            JSONArray array = new JSONArray();
            for(String item : jsonList){
                LinkedHashMap<String, Object> arrayObj = JSON.parseObject(item,LinkedHashMap.class, Feature.OrderedField);
                if(arrayObj.containsKey("provider") && arrayObj.containsKey("output") && arrayObj.containsKey("variable")){
                    str = item;
                }
                //存入json数组
                array.add(arrayObj);
            }

            //当缺失头部和尾部基础数据时抛出格式错误异常
            if(StringUtils.isBlank(str)){
                throw new TemplateException(BusinessEnum.JSON_WRONG_FORMAT.getDescription());
            }

            //符合,保存到容器中
            LinkedHashMap<String, Object> commomObj = JSON.parseObject(str,LinkedHashMap.class, Feature.OrderedField);

            //遍历获取key = resource下的内容,并合并后存储到新的json对象中
            JSONObject resourceObj = new JSONObject(true);
            for(int i=0; i<array.size(); i++){
                Object object = array.getJSONObject(i).getString("resource");
                LinkedHashMap<String, Object> linkObj = JSON.parseObject(object.toString(),LinkedHashMap.class, Feature.OrderedField);
                resourceObj.putAll(linkObj);
            }

            /**
             * 从容器中取出各部分数据,组成完整json
             */
            result.put("provider",commomObj.get("provider"));
            result.put("resource", resourceObj);
            result.put("output",commomObj.get("output"));
            result.put("variable",commomObj.get("variable"));
        } catch (Exception e){
            throw new TemplateException(BusinessEnum.JSON_MERGE.getDescription());
        }

        return result;
    }

}
