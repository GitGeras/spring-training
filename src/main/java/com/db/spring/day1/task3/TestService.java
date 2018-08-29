package com.db.spring.day1.task3;

public interface TestService {
    @Benchmark
    @Transaction
    void testMethod();
}
