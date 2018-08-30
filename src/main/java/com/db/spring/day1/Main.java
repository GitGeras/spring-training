package com.db.spring.day1;

import com.db.spring.DefaultConfig;
import com.db.spring.day1.task1.TalkingRobot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DefaultConfig.class);
        TalkingRobot talkingRobot = applicationContext.getBean(TalkingRobot.class);
        talkingRobot.talk();

        System.out.println(applicationContext.getBean("shakespeareQuoter").getClass());

        applicationContext.close();
    }
}
