package com.example.redisplus.seckill;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.redisplus.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @Author: menghuan
 * @Date: 2022/6/27 9:51
 */
@Slf4j
public class SeckillTest {

    // 总库存
    private long kuCun = 0;
    // 商品key名字
    private String shangPingKey = "computer_key";
    // 获取锁的超时时间 秒
    private int timeout = 30 * 1000;

    /**
     * 模拟抢单动作
     *
     * @param b
     * @return
     */
    private String raceToControl(String b) {
        // 用户开抢时间
        long startTime = System.currentTimeMillis();

        // 未抢到的情况下，30秒内继续获取锁
        while ((startTime + timeout) >= System.currentTimeMillis()) {
            // 商品是否剩余
            if (kuCun <= 0) {
                break;
            }
            RedisUtils redisUtils = new RedisUtils();
            if (redisUtils.setNx(shangPingKey, b)) {
                // 用户b拿到锁
                log.info("用户{}拿到锁...", b);
                try {
                    // 商品是否剩余
                    if (kuCun <= 0) {
                        break;
                    }

                    // 模拟生成订单耗时操作，方便查看：神牛-50 多次获取锁记录
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 抢购成功，商品递减，记录用户
                    kuCun -= 1;

                    // 抢单成功跳出
                    log.info("用户{}抢单成功跳出...所剩库存：{}", b, kuCun);

                    return b + "抢单成功，所剩库存：" + kuCun;
                } finally {
                    log.info("用户{}释放锁...", b);
                    // 释放锁
                    redisUtils.delNx(shangPingKey, b);
                }
            } else {
                // 用户b没拿到锁，在超时范围内继续请求锁，不需要处理
                // if (b.equals("神牛-50") || b.equals("神牛-69")) {
                // logger.info("用户{}等待获取锁...", b);
                // }
            }
        }
        return "";
    }

    @Test
    public void seckill() {

        // 抢到商品的用户
        List<String> shopUsers = new ArrayList<>();

        // 构造很多用户
        // List<String> users = new ArrayList<>();  // 数组下标越界异常
        Set<String> users = new HashSet<>();
        IntStream.range(0, 10000)
                //.boxed()
                .parallel()
                .forEach(b -> users.add("神牛-" + b)
        );

        // 初始化库存
        kuCun = 10;

        // 模拟开抢
        users
                .parallelStream()
                .forEach(b -> {
                    String shopUser = raceToControl(b);
                    if (StringUtils.isNotBlank(shopUser)) {
                        shopUsers.add(shopUser);
                    }
        });
        System.out.println(shopUsers);
    }

    /**
     * 单行
     */
    @Test
    public void serialTest(){
        // 构造很多用户
        List<String> users = new ArrayList<>();
        IntStream.range(0, 1000000)
                //.distinct()
                //.boxed()
                //.parallel()
                .forEach(b -> users.add("神牛-" + b)
                );
        System.out.println("数量：" + users.size());
    }

    /**
     * 并行
     */
    @Test
    public void parallelTest(){
        // 构造很多用户
        // List<String> users = new ArrayList<>();
        Set<String> users = new HashSet<>();
        IntStream.range(0, 100000)
                //.boxed()
                .parallel()
                .forEach(b -> users.add("神牛-" + b)
                );
        System.out.println("数量：" + users.size());
    }

    @Test
    public void testLog(){
        String logLevel = JudgeCurrentLevel();
        System.out.println(logLevel);

        log.debug("debug");
        log.info("info");
        log.error("error");
        log.warn("warn");
    }


    private String JudgeCurrentLevel(){
        if (log.isDebugEnabled()){
            return "当前日志等级：debug";
        }else if (log.isInfoEnabled()){
            return "当前日志等级：info";
        }
        else if (log.isWarnEnabled()){
            return "当前日志等级：warn";
        }
        else if (log.isErrorEnabled()){
            return "当前日志等级：error";
        }
        return log.getName();
    }

}
