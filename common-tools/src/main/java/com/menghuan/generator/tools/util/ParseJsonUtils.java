package com.menghuan.generator.tools.util;//package com.hzcloud.iot.common.core.util;
//
//
//import cn.hutool.json.JSONArray;
//import cn.hutool.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
///**
// * json处理工具类
// */
//public class ParseJsonUtils {
//
//    public static void parseJsonToMap(JSONObject jsonObject, Map<String, String> map, String parentKey) {
//        for (Object key : jsonObject.keySet()) {
//            Object val = jsonObject.get(key);
//            String fullKey = (parentKey == null || parentKey.trim().equals("") ? key.toString() : parentKey + "." + key);
//            if (val instanceof JSONArray) {
//                //如果是数组，遍历然后递归
//                Iterator it = ((JSONArray) val).iterator(); int status = 0;
//                while (it.hasNext()) { Object child = it.next();
//                    if (child instanceof Integer || child instanceof String) {
//                        //处理对象的值是数组，值中包含了数字，字符串，对象
//                        if (status == 0) {
//                            status = 1; map.put(fullKey, val.toString());
//                        }
//                    } else if (child instanceof JSONObject) {
//                        parseJsonToMap((JSONObject) child, map, fullKey);
//                    }
//                }
//            } else if (val instanceof JSONObject) {
//                //kv对象递归
//                parseJsonToMap((JSONObject) val, map, fullKey);
//            } else {
//                map.put(fullKey, String.valueOf(val));
//            }
//        }
//    }
//
//
//    public static List<JsonTree> searchChild(List<JsonTree> jsonTrees , String id){ //子集查找遍历
//        List<JsonTree> lists = new ArrayList<JsonTree>();
//        for(JsonTree a:jsonTrees){
//            if(a.getPid().equals(id)){
//                lists.add(a);
//            }
//        }
//        return lists;
//    }
//}
