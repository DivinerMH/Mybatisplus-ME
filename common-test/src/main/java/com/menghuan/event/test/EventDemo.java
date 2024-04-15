package com.menghuan.event.test;

import org.springframework.context.ApplicationEvent;

public class EventDemo extends ApplicationEvent {
    private String message;

    public EventDemo(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
