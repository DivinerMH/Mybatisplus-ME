package com.hanchan.codeTest_2021_02.Lazy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: menghuan
 * @Date: 2021/1/29 17:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyLazyTest {

    @Resource
    MyLazy myLazy;

    @Test
    public void MyLazyTest() {
        myLazy.sayHello();
    }
    
}
