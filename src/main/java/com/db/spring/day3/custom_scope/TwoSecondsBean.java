package com.db.spring.day3.custom_scope;

import javax.annotation.PostConstruct;

public class TwoSecondsBean {

    private final String name;

    public TwoSecondsBean(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println(
                String.format("Hello from %s of type %s",
                        this.name,
                        this.getClass().getName()));
    }

    @PostConstruct
    private void init(){
        System.out.println("TwoSeconds bean was created!");
    }
}