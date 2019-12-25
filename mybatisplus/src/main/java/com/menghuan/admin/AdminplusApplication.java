package com.menghuan.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author menghuan
 * @date 2018年06月21日
 * 登录权限系统
 */
@SpringBootApplication
@MapperScan(value = "com.menghuan.admin.mapper")

public class AdminplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminplusApplication.class, args);
    }

}
