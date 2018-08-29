package com.db.spring.day2;

import com.db.spring.day1.task1.Quoter;
import lombok.Data;

import javax.annotation.PreDestroy;
import java.util.List;

@Data
public class T1000 implements Quoter {
    private List<String> messages;

    @Override
    public void sayQuote() {
        System.out.println("Where is John Conar?");
    }

    public void doFinalize(){
        System.out.println("finally");
    }
}
