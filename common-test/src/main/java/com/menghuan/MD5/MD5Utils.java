package com.menghuan.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.beust.jcommander.internal.Maps;

public class MD5Utils {

    public static String MD5(String pwd) {
        try {
            // 创建加密对象
            MessageDigest digest = MessageDigest.getInstance("md5");
            // 调用加密对象的方法，加密的动作已经完成
            byte[] bs = digest.digest(pwd.getBytes());
            // 第一步，将数据全部转换成正数：
            String hexString = "";
            for (byte b : bs) {
                // 第一步，将数据全部转换成正数：
                // 解释：为什么采用b&255
                /*
                 * b:它本来是一个byte类型的数据(1个字节) 255：是一个int类型的数据(4个字节)
                 * byte类型的数据与int类型的数据进行运算，会自动类型提升为int类型 eg: b: 1001 1100(原始数据)
                 * 运算时： b: 0000 0000 0000 0000 0000 0000 1001 1100 255: 0000
                 * 0000 0000 0000 0000 0000 1111 1111 结果：0000 0000 0000 0000
                 * 0000 0000 1001 1100 此时的temp是一个int类型的整数
                 */
                int temp = b & 255;
                // 第二步，将所有的数据转换成16进制的形式
                // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                // 因此，需要对temp进行判断
                if (temp < 16 && temp >= 0) {
                    // 手动补上一个“0”
                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }


    public static String getSign(String sysSecret, Map<String, Object> map) {
        // JSONObject resultJson = JSONObject.fromObject(map);
        JSONObject resultJson = new JSONObject(map);
        System.out.println(JSONObject.toJSONString(resultJson, SerializerFeature.WriteMapNullValue));
        char[] s = JSONObject.toJSONString(resultJson, SerializerFeature.WriteMapNullValue).toCharArray();
        System.out.println(s);
        Arrays.sort(s);
        System.out.println(s);
        String outputSignOriginalStr = new String(s) + sysSecret;
        String sign = MD5(outputSignOriginalStr);
        System.out.println(sign);
        return sign;
    }

    /**
     * Map:{"timestamp": "1685015672", "appId": "100001", "integralType": "QT","account": "18827088018"}
     * @param args
     */
    public static void main(String[] args) {
        String test = MD5("test");
        System.out.println(test);
        System.out.println("==================================================");

        String sysSecret = "test";
        Map<String, Object> map = Maps.newHashMap();
        map.put("timestamp", "1685015672");
        map.put("appId", "100001");
        map.put("integralType", "QT");
        map.put("account", "18827088018");
        getSign(sysSecret, map);
    }
}