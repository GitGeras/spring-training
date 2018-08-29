package com.db.spring.day2;

import com.db.spring.day1.task1.Quoter;
import lombok.Data;

import java.util.List;

@Data
@DeprecatedClass(T1000.class)
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }


    public void doFinalize(){
        System.out.println("try finally");
    }
}
