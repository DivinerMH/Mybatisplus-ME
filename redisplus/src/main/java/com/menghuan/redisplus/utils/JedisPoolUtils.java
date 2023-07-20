package com.menghuan.redisplus.utils;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author: menghuan
 * @Date: 2022/6/23 17:52
 */
public class JedisPoolUtils {

    // 被volatile修饰的变量不会被本地线程缓存，对该变量的读写都是直接操作共享内存。
    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtils() { }

    /**
     * Jedis 连接池初始化
     * @return JedisPool
     */
    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (JedisPoolUtils.class) {
                if (null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(1000);
                    poolConfig.setMaxIdle(32);
                    poolConfig.setMaxWaitMillis(100 * 1000);
                    poolConfig.setTestOnBorrow(true);
                    jedisPool = new JedisPool(poolConfig, "192.168.1.163", 6379);
                }
            }
        }
        return jedisPool;
    }

    /**
     * 释放Jedis连接池资源
     * @param jedisPool Jedis连接池
     * @param jedis Jedis
     */
    public static void release(JedisPool jedisPool, Jedis jedis) {
        if (null != jedis) {
            Jedis jedis2 = null;
            try {
                jedis2 = jedisPool.getResource();
            } finally {
                jedis2.close();
            }
        }
    }

}