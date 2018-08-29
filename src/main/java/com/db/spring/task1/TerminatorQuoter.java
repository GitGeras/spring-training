package com.db.spring.task1;

import lombok.Data;

import java.util.List;

@Data
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}
