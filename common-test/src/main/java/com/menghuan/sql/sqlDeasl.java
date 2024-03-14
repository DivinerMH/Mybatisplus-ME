package com.menghuan.sql;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class sqlDeasl {

    public static Map<String, Integer> buildParameterOrderMap(String sql) {
        // 定义匹配 SQL 参数占位符的正则表达式
        String regex = "#\\{[a-zA-Z0-9_]+\\}";
        Pattern pattern = Pattern.compile(regex);

        // 使用 Matcher 进行匹配
        Matcher matcher = pattern.matcher(sql);
        Map<String, Integer> parameterOrderMap = new LinkedHashMap<>();

        int order = 1;
        while (matcher.find()) {
            String parameter = matcher.group();
            // 提取参数名，去除 #{ 和 }
            String parameterName = parameter.substring(2, parameter.length() - 1);
            parameterOrderMap.put(parameterName, order++);
        }

        return parameterOrderMap;
    }

    public static void main(String[] args) {
        // 示例 SQL 查询
        String sql =
            "SELECT bucket_name, object_name, object_path from dis_file_info where object_name like #{name} and object_path = #{path}";

        // 调用方法构建参数顺序 Map
        Map<String, Integer> parameterOrderMap = buildParameterOrderMap(sql);

        // 输出参数顺序 Map
        System.out.println("参数顺序 Map: " + parameterOrderMap);
    }

}
