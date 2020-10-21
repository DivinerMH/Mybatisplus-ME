package com.helper.redis;

/**
 * @author bjx
 * @date 2020-07-24
 */
public interface IRedisService {
    /**
     * 获取一个redis分布锁
     *
     * @param lockKey        锁住的key
     * @param lockExpireMils 锁住的时长。如果超时未解锁，视为加锁线程死亡，其他线程可夺取锁
     * @return
     */
    boolean lock(String lockKey, long lockExpireMils);

    /**
     * 删除key
     * @param lockKey key
     */
    void releaseLock(String lockKey);

    /**
     * 分布式锁-重入锁
     * @param lockName 锁名称
     * @param releaseTime 超时时间 秒
     * @return 解锁标识
     */
    String tryLock(String lockName, String releaseTime);

    /**
     * 释放锁
     * @param lockName 锁名称
     * @param key 解锁标识
     */
    void unlock(String lockName, String key);

}
