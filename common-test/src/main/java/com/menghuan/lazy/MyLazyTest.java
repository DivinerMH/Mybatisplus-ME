package com.menghuan.lazy;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
