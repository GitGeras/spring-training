package com.db.spring.day1.task1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class ShakespeareQuoter implements Quoter {

    @Value("${shakespeare}")
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
