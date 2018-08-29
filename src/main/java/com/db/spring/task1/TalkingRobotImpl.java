package com.db.spring.task1;

import lombok.Setter;

import java.util.List;

public class TalkingRobotImpl implements TalkingRobot {
    @Setter
    List<Quoter> quoters;

    @Override
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }
}
