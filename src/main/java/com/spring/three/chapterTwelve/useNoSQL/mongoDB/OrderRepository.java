package com.spring.three.chapterTwelve.useNoSQL.mongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {

    //编写自定义查询方法
    List<Order> findByCustomer(String c);
    List<Order> findByCustomerLike(String c);
    List<Order> findByCustomerAndType(String c, String t);
    List<Order> findByCustomerLikeAndType(String c, String t);
    //指定查询
    @Query("{'customer' : 'check wagon', 'type' : ?0}")
    List<Order> findChucksOrders(String t);
}