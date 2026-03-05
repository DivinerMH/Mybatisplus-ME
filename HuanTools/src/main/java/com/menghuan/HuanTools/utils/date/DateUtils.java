package com.menghuan.HuanTools.utils.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: menghuan
 * @Date: 2025-04-22 17:18
 */
@Slf4j
public class DateUtils {

    /**
     * 支持的日期时间格式（按优先级顺序）
     */
    private static final DateTimeFormatter[] DATE_TIME_FORMATTERS = {
        // 带时间的格式（优先级高）
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"), DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"),
        // 支持 ISO 格式：2025-04-22T10:15:30
        DateTimeFormatter.ISO_LOCAL_DATE_TIME,
        // 仅日期格式（优先级低，解析后默认时间 00:00:00）
        DateTimeFormatter.ofPattern("yyyy-MM-dd"), DateTimeFormatter.ofPattern("yyyy/MM/dd"),
        // 支持 20250422 格式
        DateTimeFormatter.BASIC_ISO_DATE};

    /**
     * 严格地将字符串解析为 {@link Date}，支持多种格式。
     * 如果所有格式均解析失败，抛出 {@link IllegalArgumentException}。
     *
     * @param dateStr 日期字符串，不可为 null 或空白（调用前请自行校验）
     * @return 解析后的 Date 对象
     * @throws IllegalArgumentException 当所有格式解析失败时抛出
     */
    public static Date stringToDate(String dateStr) throws IllegalArgumentException {
        if (StringUtils.isBlank(dateStr)) {
            throw new IllegalArgumentException("日期字符串不能为空");
        }
        // 循环匹配
        for (DateTimeFormatter formatter : DATE_TIME_FORMATTERS) {
            try {
                TemporalAccessor parsed = formatter.parse(dateStr);

                if (parsed.isSupported(java.time.temporal.ChronoField.HOUR_OF_DAY)) {
                    LocalDateTime dateTime = LocalDateTime.from(parsed);
                    return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
                } else {
                    LocalDate date = LocalDate.from(parsed);
                    LocalDateTime dateTime = date.atTime(LocalTime.MIN);
                    return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
                }
            } catch (DateTimeParseException ignored) {
                // 继续尝试
            }
        }

        throw new IllegalArgumentException("无法解析的日期格式: " + dateStr);
    }

    /**
     * 安全地将字符串解析为 {@link Date}，支持多种格式。
     * 如果解析失败，返回 null 并记录警告日志。
     *
     * @param dateStr 日期字符串，可为 null 或空白
     * @return 解析后的 Date 对象，失败时返回 null
     */
    public static Date safeParseDate(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        // 循环匹配
        for (DateTimeFormatter formatter : DATE_TIME_FORMATTERS) {
            try {
                TemporalAccessor parsed = formatter.parse(dateStr);

                // 判断解析结果是否包含时间部分
                if (parsed.isSupported(java.time.temporal.ChronoField.HOUR_OF_DAY)) {
                    // 完整日期时间
                    LocalDateTime dateTime = LocalDateTime.from(parsed);
                    return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
                } else {
                    // 仅日期部分，默认使用当天的开始时间 (00:00:00)
                    LocalDate date = LocalDate.from(parsed);
                    LocalDateTime dateTime = date.atTime(LocalTime.MIN);
                    return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
                }
            } catch (DateTimeParseException ignored) {
                // 尝试下一个格式
            }
        }

        log.warn("日期格式无法识别，忽略该字段: [{}]", dateStr);
        return null;
    }

    /**
     * 测试代码（可删除）
     */
    public static void main(String[] args) {
        // 测试安全解析
        System.out.println("安全解析：");
        System.out.println(safeParseDate("2025-01-28")); // 2025-01-28 00:00:00
        System.out.println(safeParseDate("2025/01/28 14:30:00")); // 2025-01-28 14:30:00
        System.out.println(safeParseDate("20250422")); // 2025-04-22 00:00:00
        System.out.println(safeParseDate("2025-04-22T10:15:30")); // 2025-04-22 10:15:30
        System.out.println(safeParseDate("事项完成")); // null，并记录警告

        System.out.println("\n严格解析：");
        System.out.println(stringToDate("2025-01-28"));
        System.out.println(stringToDate("2025/01/28 14:30:00"));
        try {
            System.out.println(stringToDate("事项完成"));
        } catch (IllegalArgumentException e) {
            System.out.println("捕获异常: " + e.getMessage());
        }
    }

}
