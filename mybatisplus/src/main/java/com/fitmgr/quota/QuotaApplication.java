

package com.fitmgr.quota;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author menghuan
 * @date 2018年06月21日
 * 配额管理系统
 */

@SpringBootApplication
@MapperScan(value = "com.fitmgr.admin.mapper")
public class QuotaApplication {
    public static void main(String[] args) {
        SpringApplication.run(QuotaApplication.class, args);
    }

}
