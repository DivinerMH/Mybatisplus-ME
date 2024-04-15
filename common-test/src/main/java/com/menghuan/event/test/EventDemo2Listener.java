package com.menghuan.event.test;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

// 定义一个事件监听者
@Component
public class EventDemo2Listener implements ApplicationListener<EventDemo> {
    @Override
    public void onApplicationEvent(EventDemo event) {
        System.out.println("===========");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("receiver2 " + event.getMessage());
    }
}
