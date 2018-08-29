package com.db.spring.day1.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TalkingRobotImpl implements TalkingRobot {
    @Autowired
    List<Quoter> quoters;

    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
