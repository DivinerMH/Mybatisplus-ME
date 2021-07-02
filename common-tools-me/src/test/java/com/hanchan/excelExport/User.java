package com.hanchan.excelExport;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @Author: menghuan
 * @Date: 2021/6/30 15:57
 */
@Data
@AllArgsConstructor
public class User {


    private String name;

    private String age;

    private Date birthDay;

}
