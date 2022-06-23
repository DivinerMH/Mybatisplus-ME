package com.example.redisplus.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: menghuan
 * @Date: 2022/6/22 17:36
 */
@Slf4j
@Component
public class RedisUtils{

    public boolean setNx(String key, String val) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (null == jedis) {
                return false;
            }
            /*
            * NX：是否存在key，存在就不set成功
            * PX：key过期时间单位设置为毫秒（EX：单位秒）
            */
            return jedis
                    .set(key,val,"NX","px",1000*60)
                    .equalsIgnoreCase("ok");
        } catch (Exception ex) {
            log.info("Redis分布式锁异常,请核实后操作！");
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    public int delnx(String key, String val) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null) {
                return 0;
            }

            //if redis.call('get','orderkey')=='1111' then return redis.call('del','orderkey') else return 0 end
            StringBuilder sbScript = new StringBuilder();
            sbScript.append("if redis.call('get','").append(key).append("')").append("=='").append(val).append("'").
                    append(" then ").
                    append("    return redis.call('del','").append(key).append("')").
                    append(" else ").
                    append("    return 0").
                    append(" end");

            return Integer.valueOf(jedis.eval(sbScript.toString()).toString());
        } catch (Exception ex) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }

     public static void main(String[] args) {

        RedisUtils redisUtils = new RedisUtils();
        redisUtils.setNx("KK","129");
         // redisUtils.delnx("KK","127");
    }

}
