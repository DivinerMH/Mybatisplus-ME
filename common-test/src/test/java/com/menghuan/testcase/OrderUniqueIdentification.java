package com.menghuan.testcase;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author: menghuan
 * @Date: 2021/5/27 16:38
 * https://mp.weixin.qq.com/s/MtuvIuCApbCrtg4amYmzmw    一次订单号重复引起的事故
 */
public class OrderUniqueIdentification {

    /** 订单号生成(NEW) **/
    private static final AtomicInteger SEQ = new AtomicInteger(1000);

    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmssSS");

    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");

    /**
     * @description generateOrderNo()方法内不需要加锁，因为AtomicInteger内使用的是CAS自旋转锁(保证可见性的同时也保证原子性,具体的请自行了解)
     * @return
     */
    public static String generateOrderNo(){
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if(SEQ.intValue()>9990){
            SEQ.getAndSet(1000);
        }
        return dataTime.format(DF_FMT_PREFIX) + SEQ.getAndIncrement();
    }

    public static void main(String[] args) {

        List<String> orderNos = Collections.synchronizedList(new ArrayList<String>());
        IntStream.range(0,8000).parallel().forEach(i->{
            orderNos.add(generateOrderNo());
        });

        List<String> filterOrderNos = orderNos.stream().distinct().collect(Collectors.toList());

        System.out.println("生成订单数："+orderNos.size());
        System.out.println("过滤重复后订单数："+filterOrderNos.size());
        System.out.println("重复订单数："+(orderNos.size()-filterOrderNos.size()));
        // System.out.println("=====================================================");
        // System.out.println("订单集合" + filterOrderNos);

        /*System.out.println(SEQ.getAndIncrement());
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        System.out.println(dataTime.format(DF_FMT_PREFIX));
        System.out.println(dataTime.format(DF_FMT_PREFIX) + SEQ.getAndIncrement());*/
    }
}
