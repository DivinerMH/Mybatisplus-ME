package com.menghuan.stringJSON;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: menghuan
 * @Date: 2022/9/28 11:30
 */
public class jsonToMap2 {

    public static  String abc="{\"header\":{\"version\":\"1.0\"," +
            "\"transType\":\"W387\"," +
            "\"submitTime\":\"20180717092002\"," +
            "\"sessionId\":null," +
            "\"clientTraceNo\":\"201807170500001839518200\"," +
            "\"hostTime\":\"20180717091904\"," +
            "\"hostTraceNo\":\"8500b868-bbfe-4236-825f-075598aa3f97\"," +
            "\"returnCode\":\"0000\"," +
            "\"merchantId\":\"182000899000001\"," +
            "\"terminalId\":null," +
            "\"returnMessage\":\"交易成功\"," +
            "\"transDirect\":null," +
            "\"signMessage\":\"\"}," +
            "\"body\":{\"hostSettleDate\":\"20180717\"," +
                    "\"voucherType\":\"31\"," +
                    "\"coupons\":[{\"couponsNo\":\"1817503001007701\",\"availTimes\":\"1\",\"activeDate\":\"20180103\",\"expireDate\":\"20190228\",\"password\":\"\",\"voucherType\":\"1\",\"prodID\":\"107511\",\"prodName\":\"胖叔洗车H5支付测试\"},{\"couponsNo\":\"1817503001007701\",\"availTimes\":\"1\",\"activeDate\":\"20180103\",\"expireDate\":\"20190228\",\"password\":\"\",\"voucherType\":\"1\",\"prodID\":\"107511\",\"prodName\":\"胖叔洗车H5支付测试\"}],\"containsSubCoupons\":\"1\"}}\n";

    public static void main(String[] args) {
        // System.out.println(abc);
        System.out.println(parseData(abc,"header"));
        // System.out.println(parseData(abc,"body"));
        // System.out.println(parseData(abc,"body.coupons"));
        // System.out.println(parseData(abc,"body.coupons[0].prodName"));
        // System.out.println(parseData(abc,"body.coupons[0]"));
    }

    /**
     * @Description: 解析任意结构 json  数据    list-list  无法解析
     * @date  2018/07/19
     * @author zhaolin 赵神
     */
    public static Object parseData(String jsonStr, String key) {
        Map map =(Map) JSONObject.parse(jsonStr);
        String keys[] = key.split("\\.");
        Map temp = map;
        for (int i = 0; i < keys.length; i ++) {
            boolean isEnd = i == keys.length - 1;
            String tempKey = keys[i];
            Matcher m = Pattern.compile("([a-zA-z]+)(\\[)([0-9]*)(\\])").matcher(tempKey);
            if (m.find()) {
                int index = Integer.parseInt(m.group(3));
                List list = (List)temp.get(m.group(1));
                if (isEnd)
                    return list.get(index);
                else
                    temp = (Map)list.get(index);
            } else {
                if (isEnd)
                    return temp.get(keys[keys.length-1]);
                temp = (Map)temp.get(tempKey);
            }
        }
        return null;
    }


}
