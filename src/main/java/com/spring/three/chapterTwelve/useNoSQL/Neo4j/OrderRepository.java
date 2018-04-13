package com.spring.three.chapterTwelve.useNoSQL.Neo4j;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface OrderRepository extends GraphRepository<Order>, OrderOperations {

    //添加查询方法
    List<Order> fingByCustomer (String customer);
    List<Order> findByCustomerAndType (String customer, String type);

    //自定义查询方法
    @Query("match (o:Order) - [:HAS_ITEMS] -> (i:Item) where -.product='Spring in Action' return o")
    List<Order> findSiAOrders();
}
