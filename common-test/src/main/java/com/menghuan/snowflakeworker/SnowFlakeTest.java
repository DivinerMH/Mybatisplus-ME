package com.menghuan.snowflakeworker;

import org.junit.Test;

/**
 * @Author: menghuan
 * @Date: 2022/10/9 15:42
 */
public class SnowFlakeTest {

    @Test
    public void oneTest(){
        StudentTest studentTest = new StudentTest();
        SnowFlakeWorker idWorker = new SnowFlakeWorker(0, 0);
        System.out.println("idWorker:" + idWorker);
        studentTest.setId(idWorker.nextId());
        System.out.println("studentTest:" + studentTest);
    }


}
