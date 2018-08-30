package com.db.spring.day3.aop.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessGeneralService {
    @Autowired
    private AlmostDaoService daoService;

    public void doSomeLogic() {
        daoService.doSomeLogic();
    }
}
