package com.menghuan.common.core.tools;

import java.util.ArrayList;
import java.util.List;

public class StatusUtils {
    public static final int UNCOMMITTED = 0;    // 未提交
    public static final int SUBMITTED = 1;      // 提交
    public static final int UNDER_REVIEW = 2;   // 审核中
    public static final int PASSED = 4;         // 通过
    public static final int REJECTED = 8;       // 驳回
    public static final int WITHDRAWN = 16;     // 撤销
    public static final int ARCHIVED = 32;      // 已归档

    // 位掩码
    private static final int MASK_UNCOMMITTED = 0b00000000;   // 未提交的位掩码
    private static final int MASK_SUBMITTED = 0b00000001;     // 提交的位掩码
    private static final int MASK_UNDER_REVIEW = 0b00000010;  // 审核中的位掩码
    private static final int MASK_PASSED = 0b00000100;        // 通过的位掩码
    private static final int MASK_REJECTED = 0b00001000;      // 驳回的位掩码
    private static final int MASK_WITHDRAWN = 0b00010000;     // 撤销的位掩码
    private static final int MASK_ARCHIVED = 0b00100000;      // 已归档的位掩码


    /**
     * 设置状态
     * @param status 原状态值
     * @param state 新状态值
     * @return 新状态值
     */
    public static int setState(int status, int state) {
        return status | state;
    }

    /**
     * 检查是否包含指定状态
     * @param status 状态值
     * @param state 指定状态
     * @return 是否包含指定状态
     */
    public static boolean hasState(int status, int state) {
        return (status & state) != 0;
    }

    /**
     * 清除指定状态
     * @param status 状态值
     * @param state 指定状态
     * @return 新状态值
     */
    public static int clearState(int status, int state) {
        return status & ~state;
    }

    /**
     * 将多个状态值合并成一个整数
     * @param states 多个状态值
     * @return 合并后的状态值
     */
    public static int mergeStates(int... states) {
        int result = 0;
        for (int state : states) {
            result |= state;
        }
        return result;
    }

    /**
     * 从整数中反向拆分出多个状态值
     * @param status 整数状态值
     * @return 多个状态值
     */
    public static int[] splitStatus(int status) {
        List<Integer> result = new ArrayList<>();
        if ((status & MASK_UNCOMMITTED) != 0) {
            result.add(UNCOMMITTED);
        }
        if ((status & MASK_SUBMITTED) != 0) {
            result.add(SUBMITTED);
        }
        if ((status & MASK_UNDER_REVIEW) != 0) {
            result.add(UNDER_REVIEW);
        }
        if ((status & MASK_PASSED) != 0) {
            result.add(PASSED);
        }
        if ((status & MASK_REJECTED) != 0) {
            result.add(REJECTED);
        }
        if ((status & MASK_WITHDRAWN) != 0) {
            result.add(WITHDRAWN);
        }
        if ((status & MASK_ARCHIVED) != 0) {
            result.add(ARCHIVED);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
