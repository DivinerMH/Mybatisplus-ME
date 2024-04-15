package com.menghuan.event.test;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

// 事件发布
@Component
@RequiredArgsConstructor
public class EventDemoPublish {
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message) {
        // 如果代码结构较复杂，多处发布相同的事件，建议发布事件时将this作为source传递，便于通过分析日志确定发布源
        EventDemo demo = new EventDemo(this, message);
        applicationEventPublisher.publishEvent(demo);
    }
}
