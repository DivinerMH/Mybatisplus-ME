package com.menghuan.easy;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: menghuan
 * @Date: 2022/3/25 11:20
 */
@Data
public class ExcelStudentDTO {

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("生日")
    private Date birthday;

    @ExcelProperty("薪资")
    private Double salary;

    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;

}
