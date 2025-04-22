package com.helper.time.vacation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: menghuan
 * @Date: 2025-04-22 14:20
 */
public class HolidayDataGenerator {

    // 节假日定义（日期格式: "yyyy-MM-dd"）
    private static final Map<String, String> HOLIDAYS = new HashMap<>();

    static {
        // 示例：元旦、春节（按需修改）
        HOLIDAYS.put("2025-01-01", "元旦,3");
        HOLIDAYS.put("2025-01-28", "除夕,3");
        HOLIDAYS.put("2025-01-29", "春节,3");
        HOLIDAYS.put("2025-01-30", "春节,3");
        HOLIDAYS.put("2025-01-31", "春节,3");
        HOLIDAYS.put("2025-02-01", "春节,3");
        HOLIDAYS.put("2025-02-02", "春节,3");
        HOLIDAYS.put("2025-02-03", "春节,3");
        // 添加其他节假日...
    }

    // 调休工作日（周末需上班）
    // 春节前调休
    private static final String[] WORK_WEEKENDS = {"2025-01-25", "2025-01-26"};

    public static void main(String[] args) {
        StringBuilder sql = new StringBuilder(
            "INSERT INTO \"BASE_VACATION\" (\"ID\", \"DAY_DATE\", \"DAY_NAME\", \"DAY_WEEK\", \"DAY_TYPE\", \"YRAR\", \"MONTH\") VALUES\n");

        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 12, 31);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        while (!startDate.isAfter(endDate)) {
            String dateStr = startDate.toString();
            String id = startDate.format(formatter);
            String year = String.valueOf(startDate.getYear());
            String month = String.format("%02d", startDate.getMonthValue());
            DayOfWeek dayOfWeek = startDate.getDayOfWeek();
            int weekNumber = dayOfWeek.getValue(); // 1=Monday, 7=Sunday

            // 默认值
            String dayName = "NULL";
            String dayType = "1"; // 默认为工作日

            // 判断周末
            if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
                dayType = "2"; // 休息日
            }

            // 覆盖节假日
            if (HOLIDAYS.containsKey(dateStr)) {
                String[] holidayInfo = HOLIDAYS.get(dateStr).split(",");
                dayName = "'" + holidayInfo[0] + "'";
                dayType = holidayInfo[1]; // 3-法定节假日
            }

            // 覆盖调休
            for (String workWeekend : WORK_WEEKENDS) {
                if (dateStr.equals(workWeekend)) {
                    dayName = "'调休工作日'";
                    dayType = "4"; // 调休加班日
                    break;
                }
            }

            // 拼接 SQL
            sql.append(String.format("('%s', '%s', %s, '%d', '%s', '%s', '%s')", id, dateStr, dayName, weekNumber,
                dayType, year, month));

            if (!startDate.equals(endDate)) {
                sql.append(",\n");
            }

            startDate = startDate.plusDays(1);
        }

        sql.append(";");
        System.out.println(sql);
    }
}
