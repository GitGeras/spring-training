package com.db.spring.task1;

import lombok.Data;

@Data
public class ShakespeareQuoter implements Quoter {

    private String message;

    @InjectRandomInt(min=3, max=5)
    private int repeat;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }
}
