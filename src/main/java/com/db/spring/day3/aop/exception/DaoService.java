package com.db.spring.day3.aop.exception;

import org.springframework.stereotype.Component;

@Component
public class DaoService {
    private int i;

    public void doSomeLogic() {
        if (i == 5) {
            i = 0;
            throw new DataBaseRuntimeException();
        }
        System.out.println("All right");
        i++;
    }
}
