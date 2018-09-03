package com.db.spring.day3.aop.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class LessGeneralService {
    private final AlmostDaoService daoService;

    void doSomeLogic() {
        daoService.doSomeLogic();
    }
}
