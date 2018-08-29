package com.db.spring.day1.task2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Seller {
    private String name;
    private List<Commodity> commodityList;
}
