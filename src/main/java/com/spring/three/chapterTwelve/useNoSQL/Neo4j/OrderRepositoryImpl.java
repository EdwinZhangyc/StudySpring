package com.spring.three.chapterTwelve.useNoSQL.Neo4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderOperations {

    @Autowired
    private Neo4jOperations neo4jOperations;

    @Override
    public void test(){

        Order order = new Order();
        Long id = 1L;
        Order savedOrder = neo4jOperations.save(order);
        Order findOne = neo4jOperations.findOne(id, Order.class);
        //EndResult<Order> allOrders = neo4jOperations.findAll(Order.class);
        //long orderCount = count(Orderr.class);
        neo4jOperations.delete(order);
    }

    /**
     * 混合自定义Repository行为
     * @return
     */
    @Override
    public List<Order> findSiAOrdersMix(){

        return null;
        //Result<Map<String, Object>> result = neo4jOperations.query(//执行查询
        //  "match (o:Order) - [:HAS_ITEMS] -> (i:Item) where -.product='Spring in Action' return o"
        //
        //);
        ////转换为EndResult<Order>
        //EndResult<Order> endResult = result.to(Order.class);
        ////转换为List<Order>
        //return IteratorUtil.asList(endResult);
    }


}