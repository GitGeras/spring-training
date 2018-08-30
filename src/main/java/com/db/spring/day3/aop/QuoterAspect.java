package com.db.spring.day3.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Profile("WithAspect")
public class QuoterAspect {

    @Before("execution(* com.db.spring.day1.task1..*.say*(..))")
    public void beforeSayMethods(JoinPoint jp){
        System.out.println("This is quote " + jp.getTarget().getClass().getSimpleName());
    }
}
