package com.db.spring.task3;

public class TestServiceImpl implements TestService {
    private void init(){
        System.out.println(this.getClass() + ": init");
    }

    @Override
    @Benchmark
    @Transaction
    public void testMethod(){
        System.out.println("testMethod");
    }
}
