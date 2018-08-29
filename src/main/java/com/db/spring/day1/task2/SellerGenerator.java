package com.db.spring.day1.task2;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

public class SellerGenerator {
    @Getter
    private static List<Seller> sellersList = new ArrayList<>();

    static {
        sellersList.add(new Seller("Andrew", Arrays.asList(
                new Commodity(150),
                new Commodity(300),
                new Commodity(500)
        )));
        sellersList.add(new Seller("Sam", Arrays.asList(
                new Commodity(150),
                new Commodity(300),
                new Commodity(500),
                new Commodity(500)
        )));
        sellersList.add(new Seller("Jack", Arrays.asList(
                new Commodity(150),
                new Commodity(100)
        )));

        sellersList = getSellersList().stream().sorted((o1, o2) -> getTotalPrice(o2) - getTotalPrice(o1)).collect(Collectors.toList());
    }

    private static int getTotalPrice(Seller o2) {
        return o2.getCommodityList().stream().mapToInt(Commodity::getPrice).sum();
    }
}
