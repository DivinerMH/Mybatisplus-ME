package com.menghuan.common.core.tools;

import java.util.Arrays;

import org.junit.Test;

public class StatusUtilsTest {

    @Test
    public void mergeStates() {
        int [] a = new int[]{4,8};
        System.out.println(StatusUtils.mergeStates(a));
    }

    @Test
    public void splitStatus() {
        // 假设从数据库中读取到的`status`字段值为51，即二进制为0b00110011
        int status = 33;
        // 反向拆分出多个状态值
        int[] states = StatusUtils.splitStatus(status);
        // 输出拆分出的状态值
        System.out.println(Arrays.toString(states)); // 输出
    }

}
