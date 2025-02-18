package com.menghuan.ddl.config;

import java.sql.Connection;
import java.util.List;

import com.menghuan.ddl.bean.TableStructure;
import com.menghuan.ddl.utils.DbUtil;

public class App {

    public static void main(String[] args) {

        // 数据库配置
        String sourceUrl =
            "jdbc:dm://10.83.15.233:5236/?JEECG&compatibleMode=oracle&zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";
        String sourceUser = "JEECG";
        String sourcePass = "Dfzl@2024";

        String targetUrl =
            "jdbc:dm://10.83.15.233:5236/?JEECG3&compatibleMode=oracle&zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";
        String targetUser = "JEECG";
        String targetPass = "Dfzl@2024";

        try (Connection sourceConn = DbUtil.getConnection(sourceUrl, sourceUser, sourcePass);
            Connection targetConn = DbUtil.getConnection(targetUrl, targetUser, targetPass)) {

            // 获取表列表
            List<String> sourceTables = MetadataFetcher.getTableNames(sourceConn);
            List<String> targetTables = MetadataFetcher.getTableNames(targetConn);

            // 处理所有表
            for (String table : sourceTables) {
                TableStructure source = MetadataFetcher.getTableStructure(sourceConn, table);
                TableStructure target =
                    targetTables.contains(table) ? MetadataFetcher.getTableStructure(targetConn, table) : null;

                List<String> diffs = StructureComparator.compare(source, target);
                if (!diffs.isEmpty()) {
                    String ddl = DdlGenerator.generateSyncDdl(source, target, diffs);
                    System.out.println(ddl);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}