package com.menghuan.redisplus.utils;

import org.junit.Test;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: menghuan
 * @Date: 2022/6/22 17:36
 */
@Slf4j
@Component
public class RedisUtils {

    /**
     * 加锁 提示： NX：是否存在key，存在就不set成功 PX：key过期时间单位设置为毫秒（EX：单位秒） 1 分(分钟)=60000 毫秒
     * 
     * @param key key
     * @param val value
     * @return
     */
    public boolean setNx(String key, String val) {
        JedisPool jedisPool = JedisPoolUtils.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (null == jedis) {
                return false;
            }
            // 注意 Jedis 版本(2.9.0 支持)
            return jedis.set(key, val, "NX", "PX", 1000 * 60 * 3).equalsIgnoreCase("OK");
        } catch (Exception ex) {
            log.info("Redis分布式锁加锁异常,请核实后操作！");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    /**
     * 解锁
     *
     * @param key key
     * @param val value
     * @return
     */
    public int delNx(String key, String val) {
        JedisPool jedisPool = JedisPoolUtils.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null) {
                return 0;
            }
            StringBuilder sbScript = new StringBuilder();
            sbScript.append("if redis.call('get','").append(key).append("')").append("=='").append(val).append("'")
                .append(" then ").append("    return redis.call('del','").append(key).append("')").append(" else ")
                .append("    return 0").append(" end");
            return Integer.valueOf(jedis.eval(sbScript.toString()).toString());
        } catch (Exception ex) {
            log.info("Redis分布式锁解锁异常,请核实后操作！");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }

    @Test
    public void insertNX() {
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.setNx("KK", "129");
    }

    @Test
    public void releaseNX() {
        RedisUtils redisUtils = new RedisUtils();
        redisUtils.delNx("KK", "129");
    }

}
