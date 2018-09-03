package com.db.spring.day3.aop.exception;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;

@Repository
public class DaoService {
    private int i;

/*
    @Retryable(
            value = {DataBaseRuntimeException.class},
            maxAttempts = 2,
            backoff = @Backoff(delay = 100))
*/
    public void doSomeLogic() {
        if (i > 4) {
            i = 0;
            throw new DataBaseRuntimeException();
        }
        System.out.println("All right");
        i++;
    }
}
