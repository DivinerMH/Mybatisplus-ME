package com.menghuan.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 使用 Mybatis-plus 自动生成代码
 * 参考：
 *          https://blog.csdn.net/sinat_34338162/article/details/97613493       springboot mybatis-plus 自动生成代码 generatorConfig
 *          https://blog.csdn.net/xiaoxiaole0313/article/details/117677590      MyBatis-Plus使用 Generator 代码生成器生成实体类支持Swagger2
 *          https://blog.csdn.net/liuenyiGG/article/details/120505239   postgresql数据库使用mybatis-plus自动生成代码异常
 * @Author: menghuan
 * @Date: 2019/12/26 16:15
 */
public class MyAutoGeneratorPlusSuper {

    // 全局配置
    private final static String OUTPUT_DIR = "/mybatisplus/src/main/java";      // 生成文件的输出目录
    private final static String OUTPUT_MAPPER_DIR = "/mybatisplus/src/main/resources/mapper";      // 生成mapper.xml文件的输出目录
    private final static String AUTHOR = "menghuan";                            // 开发人员
    // 数据源配置
    private final static String DATABASE_IP = "192.168.1.175";                  // 数据库id
    private final static String PORT_NUMBER = ":3306/";                         // 数据库端口号
    private final static String USERNAME = "root";                              // 数据库账号
    private final static String PASSWORD = "123456";                            // 数据库密码
    private final static String DATABASE_NAME = "iot_resource";                 // 数据库名称
    // 包配置
    private final static String PARENT = "com.hzcloud.iot";                     // 父包名 - 如果为空，将下面子包名必须写全部， 否则就只需写子包名
    private final static String MODULE_NAME = "contract";                       // 父包模块名 - 可以为空字符串
    // 自定义基类 (会导致自动生成文件，XxxController extends BaseController)
    private final static String SuperEntity = "com.baomidou.mybatisplus.samples.generator.common.BaseEntity";           // 所有实体的基类(全类名)
    private final static String SuperController = "com.baomidou.mybatisplus.samples.generator.common.BaseController";   // 所有控制器的基类(全类名)


    /**
     * <p> 读取控制台内容 </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        MyAutoGeneratorPlusSuper myAutoGeneratorPlusSuper = new MyAutoGeneratorPlusSuper();
        myAutoGeneratorPlusSuper.mainRun();
    }

    /**
     * RUN THIS
     */
    public void mainRun() {
        // 用户当前的工作目录
        final String projectPath = System.getProperty("user.dir");

        // 代码生成器
        AutoGenerator autoConfig = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig()
                .setOutputDir(projectPath + OUTPUT_DIR)     // 生成文件的输出目录（路径）
                .setFileOverride(true)                      // 默认 false ,是否覆盖已生成文件
                .setIdType(IdType.AUTO)                     // 主键策略
                .setAuthor(AUTHOR)                          // 作者名
                .setOpen(false)                             // 是否打开输出目录
                .setEnableCache(false)                      // 默认false,是否开启二级缓存
                .setBaseResultMap(true)                     // 开启 BaseResultMap
                .setBaseColumnList(true)                    // 开启 baseColumnList
                .setSwagger2(true)                          // 实体属性 Swagger2 注解 (默认：即为正常的注解)
                .setDateType(DateType.TIME_PACK)            // 时间策略 默认TIME_PACK

                .setEntityName("%s")
                .setControllerName("%sController")
                .setServiceName("I%sService")
                .setServiceImplName("%sServiceImpl")
                .setMapperName("I%sMapper")
                .setXmlName("%sMapper")
                .setIdType(IdType.AUTO);                     // 指定生成的主键类型

        autoConfig.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig()
                .setDbQuery(new MySqlQuery())                       // 数据库信息查询，默认 Mysql
                .setDbType(DbType.MYSQL)                            // 设置数据库类型，此处是 Mysql（postgresql）
                .setTypeConvert(new MySqlTypeConvert())             // 类型转换 默认mysql
                .setDriverName("com.mysql.jdbc.Driver")             // JDK7 - 驱动名称
                // dsc.setDriverName("com.mysql.cj.jdbc.Driver");   // JDK8 - 驱动名称
                .setUrl("jdbc:mysql://" + DATABASE_IP + PORT_NUMBER + DATABASE_NAME + "?useUnicode=true&useSSL=false&characterEncoding=utf8")
                // 在使用pg数据库想通过 mybatis-plus 自动生成代码的时候，如果表不在public模式中，那么就需要自己手动设置SchemaName
                // dsc.setSchemaName("public");                     // PostgreSQL schemaName
                .setUsername(USERNAME)                              // 数据库账号
                .setPassword(PASSWORD);                             // 数据库密码
        autoConfig.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig()
                // .setModuleName(scanner("模块名"));                // 自定义模块名
                .setModuleName(MODULE_NAME)                         // 父包模块名（所属模块名称），可以为空字符串
                .setParent(PARENT)                                  // 包名（自己手动设置）
                .setEntity("entity")                                // 默认：entity,controller,service,service.impl,mapper,mapper.xm
                // .setEntity("beans")
                .setController("controller");
        autoConfig.setPackageInfo(pc);

        /** 将xml生成到 resource下面 */
        // 如果模板引擎是 freemarker 模板
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity 模板
        // String templatePath = "/templates/mapper.xml.vm";
        // 如果模板引擎是 beetl
        // String templatePath = "/templates/mapper.xml.btl";

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        // 自定义配置会被优先输出
        // focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！
                // String var = projectPath + OUTPUT_MAPPER_DIR + "/" + PARENT.replaceAll("\\.", "/") + "/" + MODULE_NAME + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                String var = projectPath + OUTPUT_MAPPER_DIR
                        // + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                System.out.println("var=================== " + var);
                return var;
                // return projectPath + OUTPUT_MAPPER_DIR + "/" + PARENT.replaceAll("\\.", "/") + "/" + MODULE_NAME + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        autoConfig.setCfg(cfg);


        // 配置模板
        // String templatesPath = "templates/entity.java";          // templates/entity.java 模板路径配置，默认在templates目录下

        TemplateConfig tc = new TemplateConfig()
                .setEntity("templates/entity.java")                 // 指定自定义模板路径，注意不要带上 .ftl/.vm, 会根据使用的模板引擎自动识别
                .setService("templates/service.java")
                .setServiceImpl("templates/serviceImpl.java")
                .setController("templates/controller.java")
                .setMapper("templates/mapper.java")
                .setEntityKt("templates/entity.kt")
                .setXml("");
        autoConfig.setTemplate(tc);

        // 策略配置（个性化定制）
        StrategyConfig strategy = new StrategyConfig()
                .setCapitalMode(false)                              // 是否大写命名 默认false
                .setSkipView(true)                                  // 是否跳过试图 默认false
                .setNaming(NamingStrategy.underline_to_camel)       // 表映射 驼峰命名
                .setColumnNaming(NamingStrategy.underline_to_camel) // 字段映射 驼峰
                // .strategy.setSuperEntityClass(SuperEntity);      // 实体类自动继承 Entity,不需要也可以(禁用)
                .setEntityLombokModel(true)                         // 是否使用 lombok 默认为 false
                // .setSuperControllerClass(SuperController);       // 公共父类 - 注释后，可避免自动去继承 BaseController - （XxxController extends BaseController）
                // .setInclude(scanner("表名"));                    // 调用 scanner 启动控制台操作,(禁用时，直接按code配置生成)
                .setInclude(".+")
                .setSuperEntityColumns("id")                        // 写于父类中的公共字段
                .setControllerMappingHyphenStyle(true);
                // .setLogicDeleteFieldName("status")               // 逻辑删除字段名称
                // .setTablePrefix(pc.getModuleName() + "_");       // 将数据库表名具象化至项目中，删除 _ 之前的部分（注释后，可实现项目与数据库完美映射）
        autoConfig.setStrategy(strategy);

        // 模板引擎 : 选择 freemarker 引擎需要指定如下，注意 pom.xml 依赖必须有！
        autoConfig.setTemplateEngine(new FreemarkerTemplateEngine());
        // 模板引擎 : 选择 velocity 引擎需要指定如下，注意 pom.xml 依赖必须有！
        // autoConfig.setTemplateEngine(new VelocityTemplateEngine());

        // 执行
        autoConfig.execute();
    }


}
