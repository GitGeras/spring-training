package com.db.spring.day3.aop.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AlmostDaoService{
    @Autowired
    private DaoService daoService;

    public void doSomeLogic() {
        daoService.doSomeLogic();
    }
}
