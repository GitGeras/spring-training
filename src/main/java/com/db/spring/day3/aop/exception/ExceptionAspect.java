package com.db.spring.day3.aop.exception;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

@Aspect
@Component
public class ExceptionAspect {

    @Value("${emails}")
    private String[] emails;

    private Map<DataBaseRuntimeException, Integer> exceptions = Collections.synchronizedMap(new WeakHashMap<>());

    @Pointcut("execution(* com.db.spring.day3..*.doSomeLogic*(..))")
    public void dataBaseRuntimeExceptionPointcut() {
    }

    @AfterThrowing(pointcut = "dataBaseRuntimeExceptionPointcut()", throwing = "ex")
    public void mailException(JoinPoint jp, DataBaseRuntimeException ex) {
        if (!exceptions.containsKey(ex)) {
            exceptions = Collections.synchronizedMap(new WeakHashMap<>());
            exceptions.put(ex, 1);

            for (String email : emails) {
                System.out.println("Sending email for: " + email + "");
            }
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }

    }
}
