package com.menghuan.common.core.tools;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 *
 * @author liushiwei
 * @date 2018年5月21日 上午9:40:53
 */
public class IdGen {

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

    /**
     * 雪花算法，生成18位Long类型的id
     *
     * @return
     */
    public static long SnowflakeIdWorker() {
        return SnowflakeIdWorker.generateId();
    }

    public static void main(String[] args) {
        String uuid = uuid();
        long id = SnowflakeIdWorker();
        System.out.println(uuid);
        System.out.println(id);
    }

}
