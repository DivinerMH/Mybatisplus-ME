package com.menghuan.event.example;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

/**
 * 事件发布
 * 
 * @author Administrator
 */
@Component
@RequiredArgsConstructor
public class PublishEvent {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {
        if (applicationEventPublisher != null) {
            applicationEventPublisher.publishEvent(new ExaEvent(message));
        } else {
            // 处理未能注入的情况
            System.out.println("无法发布事件，ApplicationEventPublisher 未注入。");
        }
    }

}
