package com.db.spring.day3.aop.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Aspect
@Component
public class ExceptionAspect {

    @Value("${emails}")
    private String[] emails;

    private Set<DataBaseRuntimeException> exceptions = new HashSet<>();

    @Pointcut("execution(* com.db.spring.day3..*.doSomeLogic*(..))")
    public void dataBaseRuntimeExceptionPointcut() {
    }

    @AfterThrowing(pointcut = "dataBaseRuntimeExceptionPointcut()", throwing = "ex")
    public void mailException(JoinPoint jp, DataBaseRuntimeException ex){
        if (exceptions.add(ex)){
            for (String email : emails) {
                System.out.println("Sending email for: " + email + "");
            }
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }

        if (exceptions.size() > 10)
        {
            exceptions = new HashSet<>();
        }
    }
}
