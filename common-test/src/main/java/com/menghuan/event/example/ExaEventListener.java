package com.menghuan.event.example;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */

@Component
public class ExaEventListener {

    @EventListener
    public void listener(ExaEvent event) {
        System.out.println("监听到数据1：" + event.getExaEvent());
    }

}
