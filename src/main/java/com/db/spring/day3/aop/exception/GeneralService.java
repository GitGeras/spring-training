package com.db.spring.day3.aop.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneralService {
    private final LessGeneralService daoService;

//    @Scheduled(fixedDelay = 500)
    public void doSomeLogic() {
        daoService.doSomeLogic();
    }
}
