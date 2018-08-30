package com.db.spring.day3.test_with_spring;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaxCalculator {
    private final NdsResolver resolver;

    public double withNds(double price) {
        return price + price * resolver.getNds();
    }
}
