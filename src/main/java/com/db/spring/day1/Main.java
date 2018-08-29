package com.db.spring.day1;

import com.db.spring.day1.task1.TalkingRobot;
import com.db.spring.day1.task1.TalkingRobotImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DefaultConfig.class);
        TalkingRobot talkingRobot = applicationContext.getBean(TalkingRobot.class);
        talkingRobot.talk();
//        TestService testService = applicationContext.getBean(TestService.class);
//        testService.testMethod();
//        applicationContext.getBeansOfType(Quoter.class).values().forEach(Quoter::sayQuote);

        applicationContext.close();
    }
}
