package com.hanchan.excelExport;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: menghuan
 * @Date: 2021/6/30 15:55
 */
public class excelExport {

    @RequestMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response){
        List<User> list = new ArrayList<>();
        list.add(new User("zhangsan","1231",new Date()));
        list.add(new User("zhangsan1","1232",new Date()));
        list.add(new User("zhangsan2","1233",new Date()));
        list.add(new User("zhangsan3","1234",new Date()));
        list.add(new User("zhangsan4","1235",new Date()));
        list.add(new User("zhangsan5","1236", DateUtil.date(new Date())));
        // 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
        //自定义标题别名
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("birthDay", "生日");
        // 合并单元格后的标题行，使用默认标题样式
        writer.merge(2, "申请人员信息");
        // 一次性写出内容，使用默认样式，强制输出标题
        writer.write(list, true);
        //out为OutputStream，需要写出到的目标流
        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        // String name = StringUtils.toUtf8String("申请学院");
        String name = "申请学院";
        response.setHeader("Content-Disposition","attachment;filename="+name+".xls");
        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            // 关闭writer，释放内存
            writer.close();
        }
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }


}
