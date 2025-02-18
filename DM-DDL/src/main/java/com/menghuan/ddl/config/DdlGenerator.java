package com.menghuan.ddl.config;

/**
 * @Author: menghuan
 * @Date: 2025-02-08 17:27
 */

import java.util.List;

import org.springframework.stereotype.Component;

import com.menghuan.ddl.bean.ColumnInfo;
import com.menghuan.ddl.bean.TableStructure;

@Component
public class DdlGenerator {

    public static String generateSyncDdl(TableStructure source, TableStructure target, List<String> diffs) {
        StringBuilder sql = new StringBuilder();
        sql.append("-- 同步表: ").append(source.getTableName()).append("\n");

        // 处理新增表
        if (target == null) {
            sql.append(generateCreateTable(source));
            return sql.toString();
        }

        // 处理列变更
        diffs.forEach(diff -> {
            if (diff.startsWith("新增列")) {
                String colName = diff.split(": ")[1];
                ColumnInfo col = findColumn(source.getColumns(), colName);
                sql.append(String.format("ALTER TABLE %s ADD %s %s;\n",
                        source.getTableName(),
                        col.getName(),
                        getColumnDefinition(col)));
            }
            // 其他变更处理...
        });

        return sql.toString();
    }

    private static String generateCreateTable(TableStructure table) {
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE ").append(table.getTableName()).append(" (\n");

        // 列定义
        for (ColumnInfo col : table.getColumns()) {
            sql.append("  ").append(col.getName()).append(" ")
                    .append(getColumnDefinition(col)).append(",\n");
        }

        // 主键
        if (!table.getPrimaryKey().getColumns().isEmpty()) {
            sql.append("  PRIMARY KEY (")
                    .append(String.join(", ", table.getPrimaryKey().getColumns()))
                    .append("),\n");
        }

        sql.deleteCharAt(sql.lastIndexOf(","));
        sql.append(");\n");

        // 索引和外键需要单独生成
        return sql.toString();
    }

    private static String getColumnDefinition(ColumnInfo col) {
        return String.format("%s(%d) %s %s",
                col.getTypeName(),
                col.getColumnSize(),
                col.isNullable() ? "NULL" : "NOT NULL",
                col.getDefaultValue() != null ? "DEFAULT " + col.getDefaultValue() : "");
    }

    private static ColumnInfo findColumn(List<ColumnInfo> columns, String columnName) {
        for (ColumnInfo column : columns) {
            if (column.getName().equals(columnName)) {
                return column;
            }
        }
        return null; // 未找到匹配的列时返回null
    }

}