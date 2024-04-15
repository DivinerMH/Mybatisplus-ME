package com.menghuan.event.example;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Administrator
 */
@SpringBootTest
public class ExTest {

    @Autowired
    private PublishEvent publishEvent;

    @Test
    public void ceShi() {
        /*for (int i = 0; i < 5; i++) {
            publishEvent.publish("你若为我繁华，你好呀：" + (i + 1));
        }*/
        publishEvent.publish("你若为我繁华，你好呀：");
    }

}
