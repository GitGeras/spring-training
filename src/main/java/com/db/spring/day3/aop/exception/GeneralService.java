package com.db.spring.day3.aop.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneralService {
    @Autowired
    private LessGeneralService daoService;

    //    @Scheduled(fixedDelay = 500)
    public void doSomeLogic() {
        daoService.doSomeLogic();
    }
}
