package com.spring.three.chapterTwelve.useNoSQL.mongoDB;

import java.util.List;

public interface OrderOperations {
    List<Order> findOrdersByType(String t);
}
