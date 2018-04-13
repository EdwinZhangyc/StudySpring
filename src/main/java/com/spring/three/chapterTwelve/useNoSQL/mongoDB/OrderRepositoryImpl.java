package com.spring.three.chapterTwelve.useNoSQL.mongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * 程序清单12.7 将自定义Repository功能注入到自动生成地Repository中
 */
public class OrderRepositoryImpl implements OrderOperations {

    //注入mongoTemplate
    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Order> findOrdersByType(String t) {
        String type = t.equals("NET") ? "WEB" : t;
        //创建查询
        Criteria where = Criteria.where("type").is(t);
        Query query = Query.query(where);
        //执行查询
        return mongoOperations.find(query, Order.class);
    }
}