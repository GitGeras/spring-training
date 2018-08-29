package com.db.spring;

import com.db.spring.task3.TestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestService testService = applicationContext.getBean(TestService.class);
        testService.testMethod();
//        applicationContext.getBeansOfType(Quoter.class).values().forEach(Quoter::sayQuote);
    }
}
