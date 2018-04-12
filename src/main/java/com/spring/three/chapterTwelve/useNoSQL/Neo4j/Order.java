package com.spring.three.chapterTwelve.useNoSQL.Neo4j;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.LinkedHashSet;
import java.util.Set;

//order是节点
@NodeEntity
public class Order {

    //Graph ID
    @GraphId
    private Long id;

    private String Customer;

    private String type;

    //与条目之间的关系
    @RelatedTo(type = "HAS_ITEMS")
    private Set<Item> items = new LinkedHashSet<Item>();

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}