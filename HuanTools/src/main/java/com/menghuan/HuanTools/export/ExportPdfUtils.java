package com.menghuan.HuanTools.export;

import cn.hutool.core.util.StrUtil;
import com.lowagie.text.pdf.BaseFont;
import org.jeecg.common.util.MinioUtil;
import org.jeecg.common.util.SpringContextUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ExportPdfUtils {

    public static String HOST_URL;
    public static String RESOURCE_PATH;

    // 缓存字体文件的本地路径
    private static String FONT_FILE_PATH;
    private static final Object FONT_LOCK = new Object();

    public static void exportToPdf(Object data, String htmlname, String fileName, HttpServletResponse response) throws Exception {
        if (StrUtil.isNotBlank(fileName)) {
            fileName = "export";
        }
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".pdf");

        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // 复用核心生成逻辑
            generatePdf(data, htmlname, outputStream);
            // 将生成的PDF写入响应流
            outputStream.writeTo(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("PDF导出失败: " + e.getMessage());
        }
    }

    /**
     * 直接输出PDF到HttpServletResponse
     */
    public static void exportToPdf(Object data, String htmlname, HttpServletResponse response) throws Exception {
        exportToPdf(data, htmlname, null, response);
    }

    /**
     * 生成PDF并上传到Minio，返回文件路径
     */
    public static String exportToPdf(Object data, String htmlname, String fileName) throws Exception {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            // 复用核心生成逻辑
            generatePdf(data, htmlname, outputStream);

            byte[] pdfBytes = outputStream.toByteArray();
            try (InputStream is = new ByteArrayInputStream(pdfBytes)) {
                return MinioUtil.upload(is, fileName, "", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("PDF生成失败: " + e.getMessage());
        }
    }

    /**
     * 核心PDF生成逻辑，提取为公共方法
     */
    private static void generatePdf(Object data, String htmlname, ByteArrayOutputStream outputStream) throws Exception {
        String hostUrl = SpringContextUtils.getProperty("jeecg.minio.minio_url");
        String resourcePath = SpringContextUtils.getProperty("jeecg.minio.bucketName");

        // 生成HTML内容
        String html = generateHtmlContent(data, htmlname);

        // 使用Flying Saucer渲染PDF
        ITextRenderer renderer = new ITextRenderer();

        try {
            // 配置中文字体支持
            // 获取本地临时文件路径
            String fontPath = getFontFilePath();
            renderer.getFontResolver().addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 渲染PDF
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);
            renderer.finishPDF();
        } finally {
            renderer = null; // 帮助GC
        }
    }

    /**
     * 生成HTML内容
     */
    private static String generateHtmlContent(Object data, String htmlname) {
        // 创建模板解析器
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");

        // 创建模板引擎
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        // 准备上下文数据
        Context context = new Context();
        context.setVariable("dataList", data);

        // 生成并返回HTML
        return templateEngine.process(htmlname, context);
    }

    /**
     * 获取字体文件本地路径（首次调用时从类路径复制到临时文件）
     */
    private static String getFontFilePath() {
        if (FONT_FILE_PATH == null) {
            synchronized (FONT_LOCK) {
                if (FONT_FILE_PATH == null) {
                    // 从类路径读取字体文件（路径以 / 开头）
                    try (InputStream is = ExportPdfUtils.class.getResourceAsStream("/fonts/msyh.ttc")) {
                        if (is == null) {
                            throw new FileNotFoundException("字体文件未找到: /fonts/msyh.ttc");
                        }

                        // 创建临时文件（前缀 msyh，后缀 .ttc）
                        File tempFont = File.createTempFile("msyh", ".ttc");
                        tempFont.deleteOnExit(); // JVM 退出时自动删除

                        // 将类路径中的字体写入临时文件
                        try (FileOutputStream fos = new FileOutputStream(tempFont)) {
                            byte[] buffer = new byte[8192];
                            int len;
                            while ((len = is.read(buffer)) != -1) {
                                fos.write(buffer, 0, len);
                            }
                        }

                        FONT_FILE_PATH = tempFont.getAbsolutePath();
                    } catch (Exception e) {
                        throw new RuntimeException("加载字体文件失败", e);
                    }
                }
            }
        }
        return FONT_FILE_PATH;
    }
}
