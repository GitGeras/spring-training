package com.db.spring.day3.test_with_spring;

import org.springframework.stereotype.Repository;

@Repository
public class NdsResolverImpl implements NdsResolver {
    @Override
    public double getNds() {
        return 0.18;
    }
}
