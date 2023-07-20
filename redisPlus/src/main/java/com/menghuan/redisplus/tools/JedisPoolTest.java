package com.menghuan.redisplus.tools;

import com.menghuan.redisplus.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: menghuan
 * @Date: 2022/6/23 17:53
 */
public class JedisPoolTest {

    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtils.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("k18", "v183");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisPoolUtils.release(jedisPool, jedis);
        }
    }

}