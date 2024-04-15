package com.menghuan.event.example;

import org.springframework.context.ApplicationEvent;

/**
 * @author Administrator
 */
public class ExaEvent extends ApplicationEvent {

    private String message;

    public ExaEvent(String message) {
        super(message);
        this.message = message;
    }

    public String getExaEvent() {
        return message;
    }

}
