package com.db.spring.day1.task1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class TerminatorQuoter implements Quoter {

    @Value("${terminator}")
    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
