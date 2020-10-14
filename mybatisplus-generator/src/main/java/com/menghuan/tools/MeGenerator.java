package com.menghuan.tools;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:menghuan
 * @Date:2019/12/26 16:15
 */
public class MeGenerator {

    // 全局配置
    private final static String OUTPUT_DIR = "/mybatisplus/src/main/java";      // 生成文件的输出目录
    private final static String AUTHOR = "menghuan";                            // 开发人员
    // 数据源配置
    private final static String DATABASE_IP = "192.168.1.175";                  // 数据库id
    private final static String PORT_NUMBER = ":3036/";                         // 数据库端口号
    private final static String USERNAME = "root";                              // 数据库账号
    private final static String PASSWORD = "123456";                              // 数据库密码
    private final static String DATABASE_NAME = "iot_resource";                  // 数据库名称
    // 包配置
    private final static String PARENT = "com.hzcloud.iot";                          // 父包名。 如果为空，将下面子包名必须写全部， 否则就只需写子包名
    private final static String MODULE_NAME = "contract";                          // 父包模块名 , 可以为空字符串
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

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + OUTPUT_DIR);      // 生成文件的输出目录
        gc.setAuthor(AUTHOR);       // 作者名
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setSwagger2(true);       //实体属性 Swagger2 注解 (默认：即为正常的注解)
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://"+DATABASE_IP+PORT_NUMBER+DATABASE_NAME+"?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");         // JDK7
        // dsc.setDriverName("com.mysql.cj.jdbc.Driver");   // JDK8
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        // 自定义模块名
        // pc.setModuleName(scanner("模块名"));
        pc.setModuleName(MODULE_NAME);      // 父包模块名 , 可以为空字符串
        pc.setParent(PARENT);       // 包名（自己手动设置）
        mpg.setPackageInfo(pc);


        // 自定义配置
        /*InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };*/
        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";


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
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称、模块名（自己设置）
                return projectPath + OUTPUT_DIR + "/" + PARENT.replaceAll("\\.", "/") + "/" + MODULE_NAME + "/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


        // 配置模板
        mpg.setTemplate(new TemplateConfig().setXml(null));


        /* TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        // 指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig); */


        // 策略配置（个性化定制）
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 实体类自动继承 Entity,不需要也可以(禁用)
        // strategy.setSuperEntityClass(SuperEntity);
        strategy.setEntityLombokModel(true);    //【实体】是否为lombok模型
        // 公共父类 - 注释后，可避免自动去继承 BaseController - （XxxController extends BaseController）
        // strategy.setSuperControllerClass(SuperController);

        // 调用 scanner 启动控制台操作,禁用时，直接按code配置生成
        // strategy.setInclude(scanner("表名"));

        strategy.setInclude(".+");
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id");
        strategy.setControllerMappingHyphenStyle(true);

        // 将数据库表名具象化至项目中，删除 _ 之前的部分（注释后，可实现项目与数据库完美映射）
        //strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        // 选择 freemarker 引擎需要指定如下，注意 pom.xml 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }


}
