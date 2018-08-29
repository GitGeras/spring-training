package com.db.spring.day2;

import com.db.spring.day1.task1.Quoter;
import com.db.spring.day1.task3.TestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Quoter shakespeareQuoter = applicationContext.getBean("shakespeareQuoter", Quoter.class);
        shakespeareQuoter.sayQuote();
        applicationContext.close();
    }
}
