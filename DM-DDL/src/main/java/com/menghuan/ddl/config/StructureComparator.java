package com.menghuan.ddl.config;

/**
 * @Author: menghuan
 * @Date: 2025-02-08 17:07
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.menghuan.ddl.bean.*;

@Component
public class StructureComparator {

    public static List<String> compare(TableStructure source, TableStructure target) {
        List<String> diffs = new ArrayList<>();

        // 比较列
        compareColumns(source, target, diffs);

        // 比较主键
        comparePrimaryKeys(source, target, diffs);

        // 比较索引
        compareIndexes(source, target, diffs);

        // 比较外键
        compareForeignKeys(source, target, diffs);

        return diffs;
    }

    private static void compareColumns(TableStructure source, TableStructure target, List<String> diffs) {
        Map<String, ColumnInfo> sourceCols =
            source.getColumns().stream().collect(Collectors.toMap(ColumnInfo::getName, c -> c));
        Map<String, ColumnInfo> targetCols =
            target.getColumns().stream().collect(Collectors.toMap(ColumnInfo::getName, c -> c));

        // 检查新增列
        sourceCols.forEach((name, col) -> {
            if (!targetCols.containsKey(name)) {
                diffs.add("新增列: " + name);
            }
        });

        // 检查删除列（需要谨慎处理）
        targetCols.forEach((name, col) -> {
            if (!sourceCols.containsKey(name)) {
                diffs.add("删除列: " + name);
            }
        });

        // 检查列属性
        sourceCols.forEach((name, sCol) -> {
            ColumnInfo tCol = targetCols.get(name);
            if (tCol != null) {
                if (!sCol.getTypeName().equalsIgnoreCase(tCol.getTypeName())
                    || sCol.getColumnSize() != tCol.getColumnSize() || sCol.isNullable() != tCol.isNullable()
                    || !Objects.equals(sCol.getDefaultValue(), tCol.getDefaultValue())) {
                    diffs.add("列属性变化: " + name);
                }
            }
        });
    }

    // 其他比较方法类似，限于篇幅省略...

    /*private static void comparePrimaryKeys(TableStructure source, TableStructure target, List<String> diffs) {
        List<PrimaryKeyInfo> sourcePks = source.getPrimaryKeys();
        List<PrimaryKeyInfo> targetPks = target.getPrimaryKeys();

        // 假设主键列表中的主键是按列名唯一标识的
        Map<String, PrimaryKeyInfo> sourcePkMap =
            sourcePks.stream().collect(Collectors.toMap(pk -> pk.getName(), pk -> pk));
        Map<String, PrimaryKeyInfo> targetPkMap =
            targetPks.stream().collect(Collectors.toMap(pk -> pk.getName(), pk -> pk));

        // 检查新增主键
        sourcePkMap.forEach((name, pk) -> {
            if (!targetPkMap.containsKey(name)) {
                diffs.add("新增主键: " + name);
            }
        });

        // 检查删除主键
        targetPkMap.forEach((name, pk) -> {
            if (!sourcePkMap.containsKey(name)) {
                diffs.add("删除主键: " + name);
            }
        });
    }*/

    private static void comparePrimaryKeys(TableStructure source, TableStructure target, List<String> diffs) {
        PrimaryKeyInfo sourcePk = source.getPrimaryKey();
        PrimaryKeyInfo targetPk = target.getPrimaryKey();

        // 如果一个表有主键而另一个没有，或者主键名为null（这里假设name不应该为null）
        if (sourcePk == null && targetPk != null) {
            diffs.add("目标表添加了主键");
        } else if (sourcePk != null && targetPk == null) {
            diffs.add("源表删除了主键");
        } else if (sourcePk != null && targetPk != null) {
            // 比较主键名
            if (!Objects.equals(sourcePk.getName(), targetPk.getName())) {
                diffs.add("主键名变化: 从 " + sourcePk.getName() + " 到 " + targetPk.getName());
            }

            // 比较列（假设columns列表中的元素顺序是重要的）
            List<String> sourceColumns = sourcePk.getColumns();
            List<String> targetColumns = targetPk.getColumns();

            if (!Objects.equals(sourceColumns, targetColumns)) {
                // 找出不同的列
                List<String> diffColumns = new ArrayList<>(sourceColumns);
                diffColumns.removeAll(targetColumns);
                diffColumns.addAll(targetColumns.stream()
                        .filter(col -> !sourceColumns.contains(col))
                        .collect(Collectors.toList()));

                diffs.add("主键列变化: " + String.join(", ", diffColumns));
            }
        }
        // 如果两个主键都为null，则不添加任何差异（假设没有主键是可以的）
    }

    private static void compareIndexes(TableStructure source, TableStructure target, List<String> diffs) {
        List<IndexInfo> sourceIndexes = source.getIndexes();
        List<IndexInfo> targetIndexes = target.getIndexes();

        // 假设索引是按索引名唯一标识的
        Map<String, IndexInfo> sourceIndexMap =
            sourceIndexes.stream().collect(Collectors.toMap(IndexInfo::getIndexName, idx -> idx));
        Map<String, IndexInfo> targetIndexMap =
            targetIndexes.stream().collect(Collectors.toMap(IndexInfo::getIndexName, idx -> idx));

        // 检查新增索引
        sourceIndexMap.forEach((name, idx) -> {
            if (!targetIndexMap.containsKey(name)) {
                diffs.add("新增索引: " + name);
            }
        });

        // 检查删除索引
        targetIndexMap.forEach((name, idx) -> {
            if (!sourceIndexMap.containsKey(name)) {
                diffs.add("删除索引: " + name);
            }
        });

        // 检查索引列的变化（可选，根据需求实现）
    }

    private static void compareForeignKeys(TableStructure source, TableStructure target, List<String> diffs) {
        List<ForeignKeyInfo> sourceFks = source.getForeignKeys();
        List<ForeignKeyInfo> targetFks = target.getForeignKeys();

        // 假设外键是按外键名唯一标识的
        Map<String, ForeignKeyInfo> sourceFkMap =
            sourceFks.stream().collect(Collectors.toMap(ForeignKeyInfo::getFkName, fk -> fk));
        Map<String, ForeignKeyInfo> targetFkMap =
            targetFks.stream().collect(Collectors.toMap(ForeignKeyInfo::getFkName, fk -> fk));

        // 检查新增外键
        sourceFkMap.forEach((name, fk) -> {
            if (!targetFkMap.containsKey(name)) {
                diffs.add("新增外键: " + name);
            }
        });

        // 检查删除外键
        targetFkMap.forEach((name, fk) -> {
            if (!sourceFkMap.containsKey(name)) {
                diffs.add("删除外键: " + name);
            }
        });

        // 检查外键属性的变化（可选，根据需求实现）
    }

}
