package com.menghuan.HuanTools.utils;

import java.net.InetAddress;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import com.menghuan.HuanTools.bean.api.ApiCode;
import com.menghuan.HuanTools.valid.BusinessValidator;

/**
 * 自增编码工具
 *
 * @author Administrator
 */
public final class SerializableCodeUtil {

    private static final String RESOURCE_OVERFLOW_NOT_EXISTS = "今日编码已达最大值，请明日再试";
    private static final String CURR_STR_AND_INIT_NOT_MATCH = "当前最大序列与初始化编码位数不匹配，请核实后操作";
    private static final String FORMAT_STR = "yyyyMMdd";
    private static final String FORMAT_STR_ALL = "yyyyMMddHHmmssSSS";
    /** 自增编码 - 初始化编码 - 短、中、长 */
    private static final String INIT_CODE = "0001";
    private static final String INIT_CODE_SIX = "000001";
    private static final String INIT_CODE_EIGHT = "00000001";

    private static final AtomicInteger sequence = new AtomicInteger(0);
    private static long lastTimestamp = 0L;

    // 机器标识（取IP末8位）
    private static final String MACHINE_ID = getMachineId();

    private static String getMachineId() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String hostAddress = ip.getHostAddress();
            // 取IP地址最后8位哈希值
            return String.format("%08x", hostAddress.hashCode() & 0xFFFFFFFF);
        } catch (Exception e) {
            // 默认标识
            return "00000000";
        }
    }

    /**
     * 基于时间的自增编码工具（存在并发风险）
     *
     * @param currStr 当前最大序列（参考：20250110000000）
     * @return 编码Code
     */
    public static String incrementCode(String currStr) {
        if (StringUtils.isBlank(currStr)) {
            return LocalDate.now().format(DateTimeFormatter.ofPattern(FORMAT_STR)) + INIT_CODE;
        }
        BusinessValidator.isTrue(currStr.substring(8).length() == INIT_CODE.length(), CURR_STR_AND_INIT_NOT_MATCH);
        Long temp = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + INIT_CODE);
        Long tempCheck = Long.parseLong(currStr) + 1;
        BusinessValidator.isTrue(tempCheck < temp - 1, ApiCode.RESOURCE_OVERFLOW_NOT_EXISTS);
        return tempCheck.toString();
    }

    /**
     * 基于时间的自增编码工具（存在并发风险）
     *
     * @param currStr 当前最大序列（参考：20250110000000）
     * @param init 初始化编码位数（参考：000000）
     * @return 编码Code
     */
    public static String incrementCode(String currStr, String init) {
        if (StringUtils.isBlank(currStr)) {
            return LocalDate.now().format(DateTimeFormatter.ofPattern(FORMAT_STR)) + init;
        }
        BusinessValidator.isTrue(currStr.substring(8).length() == init.length(), CURR_STR_AND_INIT_NOT_MATCH);
        Long temp = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + init);
        Long tempCheck = Long.parseLong(currStr) + 1;
        BusinessValidator.isTrue(tempCheck < temp - 1, ApiCode.RESOURCE_OVERFLOW_NOT_EXISTS);
        return tempCheck.toString();
    }

    /**
     * 基于时间的自增编码工具
     *
     * @param currStr 当前最大序列（参考：20250110000000）
     * @param init 初始化编码位数（参考：000000）
     * @param prefix 初始化编码前缀（参考：GGFW、GGSQ）
     * @return 编码Code
     */
    public static String incrementCode(String currStr, String init, String prefix) {
        if (StringUtils.isNotBlank(prefix)) {
            currStr = currStr.replace(prefix, "");
        }
        // 校验：当前最大序列（除去前缀）与初始化编码位数 是否匹配
        BusinessValidator.isTrue(currStr.substring(8).length() == init.length(), CURR_STR_AND_INIT_NOT_MATCH);
        if (StringUtils.isBlank(currStr)) {
            return prefix + LocalDate.now().format(DateTimeFormatter.ofPattern(FORMAT_STR)) + init;
        }
        Long temp = Long.valueOf(Long.valueOf(currStr.substring(0, 8)) + 1 + init);
        Long tempCheck = Long.parseLong(currStr) + 1;
        BusinessValidator.isTrue(tempCheck < temp - 1, ApiCode.RESOURCE_OVERFLOW_NOT_EXISTS);
        return prefix + tempCheck;
    }

    /**
     * 提醒：禁止循环调用，存在重复风险 基于时间的随机编码工具 public static String incrementTimeCode() { return
     * LocalDateTime.now().format(DateTimeFormatter.ofPattern(FORMAT_STR_ALL)) + Math.round(Math.random() * 10000);
     * 
     * @return 编码Code
     */
    public static String incrementTimeCode() {
        Pair<String, Integer> timeCodePair = timeCode();
        String timePart = timeCodePair.getLeft();
        Integer seq = timeCodePair.getRight();
        // 组合：时间 + 机器标识 + 序列号
        return timePart + String.format("%04d", seq % 10000);
    }

    /**
     * 基于时间 + 机器标识 + 序列号 的随机编码工具
     *
     * @return 编码Code
     */
    public static String incrementMachineTimeCode() {
        Pair<String, Integer> timeCodePair = timeCode();
        String timePart = timeCodePair.getLeft();
        Integer seq = timeCodePair.getRight();
        return timePart + MACHINE_ID + String.format("%04d", seq);
    }

    private static Pair<String, Integer> timeCode() {
        long currentTimestamp;
        int seq;
        String timePart;
        synchronized (SerializableCodeUtil.class) {
            currentTimestamp = System.currentTimeMillis();
            // 处理时钟回拨问题
            if (currentTimestamp < lastTimestamp) {
                // 时钟回拨，等待直到时间追上
                while (currentTimestamp < lastTimestamp) {
                    currentTimestamp = System.currentTimeMillis();
                }
                sequence.set(0);
            }
            // 同一毫秒内的序列处理
            if (currentTimestamp == lastTimestamp) {
                seq = sequence.getAndIncrement();
                // 序列号达到最大值，等待下一毫秒
                if (seq >= 9999) {
                    while (currentTimestamp <= lastTimestamp) {
                        currentTimestamp = System.currentTimeMillis();
                    }
                    sequence.set(0);
                    seq = 0;
                }
            } else {
                sequence.set(0);
                seq = sequence.getAndIncrement();
                lastTimestamp = currentTimestamp;
            }
            // 使用currentTimestamp生成时间字符串
            Instant instant = Instant.ofEpochMilli(currentTimestamp);
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            timePart = dateTime.format(DateTimeFormatter.ofPattern(FORMAT_STR_ALL));
        }
        return Pair.of(timePart, seq);
    }

    /**
     * 根据当前时间截取 FORMAT_STR 格式数据转为String
     * 
     * @return
     */
    public static String generateFormatString() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(FORMAT_STR));
    }

    /**
     * 构建前缀的通用方法
     * 
     * @param part1 Str1
     * @param part2 Str2
     * @return Str1 + Str2
     */
    public static String buildPrefix(String part1, String part2) {
        return new StringBuilder(part1).append(part2).toString();
    }

    public static void main(String[] args) {
        System.out.println("incrementCode(currStr) : " + incrementCode("202505140002"));
        System.out.println("incrementCode(currStr, init) : " + incrementCode("20250514999999", "000001"));
        System.out
            .println("incrementCode(currStr, init, prefix) : " + incrementCode("20250514999998", "000001", "CGSQ"));

        IntStream.range(0, 10000).forEach(a -> {
            System.out.println("incrementMachineTimeCode() : " + incrementMachineTimeCode());
        });

        IntStream.range(0, 1000000).forEach(a -> {
            System.out.println("incrementTimeCode() : " + incrementTimeCode());
        });
    }

}