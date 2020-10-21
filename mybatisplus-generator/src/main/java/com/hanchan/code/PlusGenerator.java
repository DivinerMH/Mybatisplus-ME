package com.hanchan.code;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;

@Component
public class PlusGenerator {

    private static final String DB_URL = "192.168.1.175";

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "123456";

    //
    // com.mysql.jdbc.Driver
    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private static Environment env;

    @Autowired
    public void set(Environment env) throws IOException {
        PlusGenerator.env = env;
    }

    /**
     * key不存在则返回null
     * @param key
     * @return
     */
    public static String getString(String key) {
        try {
            return env.getProperty(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }


    /**
     * @param author  作者
     * @param packageName 包名
     * @param dbType 数据库类型（mysql、oracle）
     * @param tableName 表名
     */
    public static void generatorByType(String author, String packageName,String dbType, String ... tableName) {

        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        final GlobalConfig gc = new GlobalConfig();
        System.out.println(PlusGenerator.class.getClassLoader().getResource("").getPath()+ "/codeGenerator");
        gc.setOutputDir(PlusGenerator.class.getClassLoader().getResource("").getPath()+ "/codeGenerator");
        gc.setFileOverride(true);
        // ActiveRecord特性
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setDateType(DateType.ONLY_DATE);
        if(StringUtils.isBlank(author)){
            author = "未知";
        }
        gc.setAuthor(author);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.getDbType(dbType));
        dsc.setTypeConvert(new OracleTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(gc, fieldType);
            }
        });
        dsc.setDriverName(getString(DRIVER_CLASS_NAME));
        dsc.setUsername(getString(USER_NAME));
        dsc.setPassword(getString(PASSWORD));
        dsc.setUrl(getString(DB_URL));
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        //strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(tableName); // 需要生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        pc.setController("controller");
        pc.setEntity("persistence.entity");
        pc.setMapper("persistence.mapper");
        mpg.setPackageInfo(pc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/vm/controller.java.vm");
        tc.setService("/vm/service.java.vm");
        tc.setServiceImpl("/vm/serviceImpl.java.vm");
        tc.setEntity("/vm/entity.java.vm");
        tc.setMapper("/vm/mapper.java.vm");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        mpg.setTemplate(tc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        mpg.setCfg(cfg);

        // 执行生成
        mpg.execute();

        // 打印注入设置【可无】
        System.err.println("代码生成成功！！");
    }


}