package com.db.spring.day3.test_with_spring;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TaxCalculatorConfiguration.class)
public class TaxCalculatorTest {

    @Autowired
    TaxCalculator taxCalculator;

    public TaxCalculatorTest(){
        System.out.println("test object was created");
    }

    @BeforeClass
    public static void test() {
        System.out.println("beforeClass");
    }

    @Test
    public void withNds() {
        double withNds = taxCalculator.withNds(100);
        assertEquals(withNds, 118, 0.0001);
    }
    @Test
    public void test1() {
        assertEquals(1, 1);
    }
}
