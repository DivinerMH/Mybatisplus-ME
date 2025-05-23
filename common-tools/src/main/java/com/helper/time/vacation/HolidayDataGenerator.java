package com.helper.time.vacation;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * @Author: menghuan
 * @Date: 2025-04-22 14:20
 */
public class HolidayDataGenerator {

    /**
     * 默认表名和字段名（可按需修改）
     */
    private static final String TABLE_NAME = "BASE_VACATION";
    private static final String[] COLUMNS =
        {"\"ID\"", "\"DAY_DATE\"", "\"DAY_NAME\"", "\"DAY_WEEK\"", "\"DAY_TYPE\"", "\"YEAR\"", "\"MONTH\""};

    /**
     * 存储节假日和调休规则
     */
    private static final Map<LocalDate, String> HOLIDAY_MAP = new HashMap<>();
    private static final Set<LocalDate> WORK_WEEKEND_SET = new HashSet<>();

    /**
     * 用法示例
     *
     * @param args
     */
    public static void main(String[] args) {
        // 元旦
        addHoliday("2025-01-01", "元旦", "3");

        // 春节
        addHoliday("2025-01-28", "除夕", "3");
        addHoliday("2025-01-29", "春节", "3");
        addHoliday("2025-01-30", "春节", "3");
        addHoliday("2025-01-31", "春节", "3");
        addHoliday("2025-02-01", "春节", "3");
        addHoliday("2025-02-02", "春节", "3");
        addHoliday("2025-02-03", "春节", "3");
        addHoliday("2025-02-04", "春节", "3");

        // 清明节
        addHoliday("2025-04-04", "清明节", "3");
        addHoliday("2025-04-05", "清明节", "3");
        addHoliday("2025-04-06", "清明节", "3");

        // 劳动节
        addHoliday("2025-05-01", "劳动节", "3");
        addHoliday("2025-05-02", "劳动节", "3");
        addHoliday("2025-05-03", "劳动节", "3");
        addHoliday("2025-05-04", "劳动节", "3");
        addHoliday("2025-05-05", "劳动节", "3");

        // 端午节
        addHoliday("2025-05-31", "端午节", "3");
        addHoliday("2025-06-01", "端午节", "3");
        addHoliday("2025-06-02", "端午节", "3");

        // 中秋节 + 国庆节
        addHoliday("2025-10-01", "国庆节", "3");
        addHoliday("2025-10-02", "国庆节", "3");
        addHoliday("2025-10-03", "国庆节", "3");
        addHoliday("2025-10-04", "国庆节", "3");
        addHoliday("2025-10-05", "国庆节", "3");
        addHoliday("2025-10-06", "国庆节+中秋节", "3");
        addHoliday("2025-10-07", "国庆节", "3");
        addHoliday("2025-10-08", "国庆节", "3");

        // ==================== 添加调休工作日 ====================

        // 春节前调休
        addWorkWeekend("2025-01-26");
        addWorkWeekend("2025-02-08");

        // 劳动节调休
        addWorkWeekend("2025-04-27");

        // 端午节调休

        // 中秋+国庆调休
        addWorkWeekend("2025-09-28");
        addWorkWeekend("2025-10-11");

        // 生成SQL
        String sql = generateHolidaySql(2025);
        System.out.println(sql);
    }

    /**
     * 添加节假日
     * 
     * @param dateStr 日期字符串（yyyy-MM-dd）
     * @param name 节假日名称
     * @param type 类型（3-法定节假日）
     */
    public static void addHoliday(String dateStr, String name, String type) {
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
        HOLIDAY_MAP.put(date, name + "," + type);
    }

    /**
     * 添加调休工作日
     * 
     * @param dateStr 日期字符串（yyyy-MM-dd）
     */
    public static void addWorkWeekend(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
        WORK_WEEKEND_SET.add(date);
    }

    /**
     * 生成节假日SQL
     * 
     * @param year 年份
     * @return SQL字符串
     */
    public static String generateHolidaySql(int year) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO ").append(TABLE_NAME).append(" (").append(String.join(", ", COLUMNS))
            .append(") VALUES\n");

        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year, 12, 31);
        DateTimeFormatter idFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        while (!startDate.isAfter(endDate)) {
            sql.append(generateRowSql(startDate, idFormatter));
            startDate = startDate.plusDays(1);
            if (!startDate.isAfter(endDate)) {
                sql.append(",\n");
            }
        }
        sql.append(";");
        return sql.toString();
    }

    /**
     * 生成单行数据SQL
     */
    private static String generateRowSql(LocalDate date, DateTimeFormatter idFormatter) {
        String id = date.format(idFormatter);
        String dateStr = date.toString();
        String year = String.valueOf(date.getYear());
        String month = String.format("%02d", date.getMonthValue());
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        String dayName = "NULL";
        String dayType = calculateDayType(date, dayOfWeek);

        // 处理节假日名称
        if (HOLIDAY_MAP.containsKey(date)) {
            String holidayInfo = HOLIDAY_MAP.get(date);
            dayName = "'" + holidayInfo.split(",")[0] + "'";
        }

        return String.format("('%s', '%s', %s, '%d', '%s', '%s', '%s')", id, dateStr, dayName, dayOfWeek.getValue(),
            dayType, year, month);
    }

    /**
     * 计算日期类型
     */
    private static String calculateDayType(LocalDate date, DayOfWeek dayOfWeek) {
        if (WORK_WEEKEND_SET.contains(date)) {
            // 调休加班日
            return "4";
        }
        if (HOLIDAY_MAP.containsKey(date)) {
            // 法定节假日
            return HOLIDAY_MAP.get(date).split(",")[1];
        }
        return (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) ? "2" : "1";
    }

    /**
     * 自动计算工作日：根据入参时间自动往后推3天(跳过周末和法定节假日)
     * 
     * @param date 入参时间
     * @return Date 返回时间
     */
    public static Date workingDayCalculator(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("输入日期不能为null");
        }
        // 基础数据（提前获取并缓存）：获取当前日期和可能涉及的年份（当前年+明年）
        ZonedDateTime zonedDateTime = date.toInstant().atZone(ZoneId.systemDefault());
        /*LocalDate startDate = zonedDateTime.toLocalDate();
        int currentYear = startDate.getYear();
        List<String> years = Arrays.asList(String.valueOf(currentYear), String.valueOf(currentYear + 1));
        
        // 跨年查询节假日数据
        List<RspBaseVacationDto> list = years.stream().flatMap(
                year -> baseVacationMapper.queryByConditions(ReqBaseVacationQueryDto.builder().year(year).build()).stream())
                .collect(Collectors.toList());
        BusinessValidator.isTrue(CollectionUtils.isNotEmpty(list), ApiCode.NOT_FOUND);
        
        // 2. 预处理（节假日和调休）数据（避免在循环中重复计算）
        Set<LocalDate> holidaySet = list.stream().filter(dto -> "3".equals(dto.getDayType()))
                .map(dto -> parseDate(dto.getDayDate())).collect(Collectors.toSet());
        
        Set<LocalDate> workWeekendSet = list.stream().filter(dto -> "4".equals(dto.getDayType()))
                .map(dto -> parseDate(dto.getDayDate())).collect(Collectors.toSet());*/

        Set<LocalDate> holidaySet = null;
        Set<LocalDate> workWeekendSet = null;

        // 保留入参的时分秒
        LocalDateTime currentDateTime = zonedDateTime.toLocalDateTime();
        int count = 0;
        while (count < 3) {
            currentDateTime = currentDateTime.plusDays(1);
            LocalDate currentDate = currentDateTime.toLocalDate();

            if (isWorkingDay(currentDate, holidaySet, workWeekendSet)) {
                count++;
            }
        }
        // 返回时保持原始时分秒
        return Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 判断是否为有效工作日
     */
    private static boolean isWorkingDay(LocalDate date, Set<LocalDate> holidaySet, Set<LocalDate> workWeekendSet) {
        // 1. 排除法定节假日
        if (holidaySet.contains(date)) {
            return false;
        }

        // 2. 判断是否自然周末且非调休工作日
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        boolean isWeekend = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        return !(isWeekend && !workWeekendSet.contains(date));
    }

    /**
     * 安全的日期解析方法
     */
    private LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DateTimeFormatter.ISO_DATE);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("非法日期格式: " + dateStr, e);
        }
    }

}
