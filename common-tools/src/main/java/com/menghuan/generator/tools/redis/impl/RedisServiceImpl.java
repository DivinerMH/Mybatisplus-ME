package com.menghuan.generator.tools.redis.impl;

import com.hzcloud.iot.common.core.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

/**
 * Redis工具类
 * @author bjx
 * @date 2020-07-23
 */
@Slf4j
@Component
public class RedisServiceImpl implements IRedisService {

    /*@Resource
    private RedisTemplate redisTemplate;*/

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final DefaultRedisScript<Long> LOCK_SCRIPT;
    private static final DefaultRedisScript<Object> UNLOCK_SCRIPT;

    static {
        // 加载释放锁的脚本
        LOCK_SCRIPT = new DefaultRedisScript<>();
        LOCK_SCRIPT.setScriptSource(new ResourceScriptSource(new ClassPathResource("/redis/lock.lua")));
        LOCK_SCRIPT.setResultType(Long.class);

        // 加载释放锁的脚本
        UNLOCK_SCRIPT = new DefaultRedisScript<>();
        UNLOCK_SCRIPT.setScriptSource(new ResourceScriptSource(new ClassPathResource("/redis/unlock.lua")));
    }

    /**
     * 获取一个redis分布锁
     *
     * @param lockKey        锁住的key
     * @param lockExpireMils 锁住的时长。如果超时未解锁，视为加锁线程死亡，其他线程可夺取锁
     * @return
     */
    public boolean lock(String lockKey, long lockExpireMils) {
        return (Boolean) stringRedisTemplate.execute((RedisCallback) connection -> {
            long nowTime = System.currentTimeMillis();
            Boolean acquire = connection.setNX(lockKey.getBytes(), String.valueOf(nowTime + lockExpireMils + 1).getBytes());
            if (acquire) {
                return Boolean.TRUE;
            } else {
                byte[] value = connection.get(lockKey.getBytes());
                if (Objects.nonNull(value) && value.length > 0) {
                    long oldTime = Long.parseLong(new String(value));
                    if (oldTime < nowTime) {
                        //connection.getSet：返回这个key的旧值并设置新值。
                        byte[] oldValue = connection.getSet(lockKey.getBytes(), String.valueOf(nowTime + lockExpireMils + 1).getBytes());
                        //当key不存时会返回空，表示key不存在或者已在管道中使用
                        return oldValue == null ? false : Long.parseLong(new String(oldValue)) < nowTime;
                    }
                }
            }
            return Boolean.FALSE;
        });
    }

    /**
     * 删除key
     * @param lockKey key
     */
    public void releaseLock(String lockKey) {
        stringRedisTemplate.delete(lockKey);
    }

    @Override
    public String tryLock(String lockName, String releaseTime) {
        // 存入的线程信息的前缀，防止与其它JVM中线程信息冲突
        String key = UUID.randomUUID().toString();

        // 执行脚本
        Long result = stringRedisTemplate.execute(
                LOCK_SCRIPT,
                Collections.singletonList(lockName),
                key + Thread.currentThread().getId(), releaseTime);

        // 判断结果
        if(result != null && result.intValue() == 1) {
            return key;
        }else {
            return null;
        }
    }

    @Override
    public void unlock(String lockName, String key) {
        // 执行脚本
        stringRedisTemplate.execute(
                UNLOCK_SCRIPT,
                Collections.singletonList(lockName),
                key + Thread.currentThread().getId(), null);
    }

}
