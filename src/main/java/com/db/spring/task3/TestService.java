package com.db.spring.task3;

public interface TestService {
    @Benchmark
    @Transaction
    void testMethod();
}
