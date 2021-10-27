依赖：

<!--文件上传组件-->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.3.3</version>
</dependency>
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.5</version>
</dependency>
<!--读取excel文件-->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>3.17</version>
</dependency>
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>3.17</version>
</dependency>

<!-- servlet插件 -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
</dependency>

<!-- 基于poi的excel反射插件 -->
<dependency>
    <groupId>com.github.crab2died</groupId>
    <artifactId>Excel4J</artifactId>
    <version>2.1.4-Final2</version>
</dependency>



注意：
1、版本匹配问题，最新版本会存在依赖报错
2、下载Excel文件模板 (Excel导入需要使用，则项目中需要有该模板文件)