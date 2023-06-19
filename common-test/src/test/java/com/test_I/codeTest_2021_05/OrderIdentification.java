package com.test_I.codeTest_2021_05;

import org.junit.platform.commons.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: menghuan
 * @Date: 2021/5/27 16:44
 */
public class OrderIdentification {

    /**
     * OD单号生成
     * 订单号生成规则：OD + yyMMddHHmmssSSS + 5位数(商户ID3位 + 随机数 2 位) 22位
     * @param merchId 商户id
     * @return 订单号
     */
    public static String getYYMMDDHHNumber(String merchId){
        StringBuffer orderNumber = new StringBuffer(new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()));
        // System.out.println("orderNumber 17位数:" + orderNumber);
        if(StringUtils.isNotBlank(merchId)){
            if(merchId.length()>3){
                orderNumber.append(merchId.substring(0,3));
            }else {
                orderNumber.append(merchId);
            }
        }
        // 经过id条件过滤 orderNumber 的长度必然为 ≤ 20，
        int orderLength = orderNumber.toString().length();
        String randomNum = getRandomByLength(20-orderLength);
        orderNumber.append(randomNum);
        return orderNumber.toString();
    }


    /** 生成指定位数的随机数 **/
    public static String getRandomByLength(int size){
        if(size>8 || size<1){
            return "";
        }
        Random ne = new Random();
        StringBuffer endNumStr = new StringBuffer("1");
        StringBuffer staNumStr = new StringBuffer("9");
        for(int i=1;i<size;i++){
            endNumStr.append("0");
            staNumStr.append("0");
        }
        int randomNum = ne.nextInt(Integer.valueOf(staNumStr.toString()))+Integer.valueOf(endNumStr.toString());
        return String.valueOf(randomNum);
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        // 商户ID
        final String merchId = "12334";
        List<String> orderNos = Collections.synchronizedList(new ArrayList<String>());
        // 以100个并发测试下这个订单号生成
        IntStream.range(0,100).parallel().forEach(i->{
            orderNos.add(getYYMMDDHHNumber(merchId));
        });

        // 过滤重复后订单数,形成新的String集合
        List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());

        System.out.println("生成订单数："+orderNos.size());
        System.out.println("过滤重复后订单数："+filterOrderNos.size());
        System.out.println("重复订单数："+(orderNos.size()-filterOrderNos.size()));
    }


}
