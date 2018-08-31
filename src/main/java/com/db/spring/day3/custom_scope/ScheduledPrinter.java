package com.db.spring.day3.custom_scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledPrinter {

    @Autowired
    private TwoSecondsBean foo;

    @Scheduled(fixedDelay = 1500)
    private void print(){
        foo.sayHello();
    }
}
