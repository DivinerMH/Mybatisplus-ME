package com.example.redisplus.tools;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: menghuan
 * @Date: 2022/6/23 11:11
 */
@Slf4j
public class InitConnect {

    /**
     * 连接Redis
     */
    @Test
    public void initConn() {
        // 创建jedis对象，连接redis服务
        Jedis jedis = new Jedis("192.168.1.163", 6379);

        // 设置认证密码
        // jedis.auth("admin");

        // 指定数据库 默认是0
        jedis.select(1);

        // 使用ping命令，测试连接是否成功
        String result = jedis.ping();
        // 返回PONG
        log.info("result：{}",result);
        // System.out.println(result);

        // 添加一条数据
        jedis.set("username", "寒山月初℃");

        // 获取一条数据
        String username = jedis.get("username");
        log.info("username：{}",username);
        // System.out.println(username);

        // 释放资源
        if (null != jedis){
            jedis.close();
        }
    }

    /**
     * 通过Redis连接池获取连接对象
     */
    @Test
    public void initConn02() {
        // 初始化redis客户端连接池
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "192.168.1.163", 	 6379, 10000);

        // 从连接池获取连接
        Jedis jedis = jedisPool.getResource();

        // 指定数据库 默认是0
        jedis.select(1);

        // 使用ping命令，测试连接是否成功
        String result = jedis.ping();
        System.out.println(result);// 返回PONG

        // 添加一条数据
        jedis.set("username_2", "寒山月初℃_2");

        // 获取一条数据
        String username = jedis.get("username_2");
        System.out.println(username);
        // 释放资源
        if (null != jedis){
            jedis.close();
        }
    }


}
