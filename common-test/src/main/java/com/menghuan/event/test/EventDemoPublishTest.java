package com.menghuan.event.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EventDemoPublishTest {

    @Autowired
    private EventDemoPublish eventDemoPublish;

    @Test
    void testEventDemoPublish() {
        eventDemoPublish.publish("test message");
    }

}
