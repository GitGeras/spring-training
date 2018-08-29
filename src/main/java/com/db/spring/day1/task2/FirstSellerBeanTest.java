package com.db.spring.day1.task2;

import javax.annotation.PostConstruct;

public class FirstSellerBeanTest {
    @InjectSeller
    private Seller seller;

    @PostConstruct
    private void init(){
        System.out.println(seller);
    }
}
