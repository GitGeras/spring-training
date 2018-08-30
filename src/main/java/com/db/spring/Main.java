package com.db.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DefaultConfig.class);
//        applicationContext.getBean("generalService", Service.class).doSomeLogic();
//        applicationContext.close();
    }
}
