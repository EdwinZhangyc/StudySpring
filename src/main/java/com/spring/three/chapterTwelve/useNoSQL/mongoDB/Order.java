package com.spring.three.chapterTwelve.useNoSQL.mongoDB;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Collection;
import java.util.LinkedHashSet;

@Document//这是一个文档
public class Order {

    //指定ID
    @Id
    private String id;

    //覆盖默认的域名
    @Field("client")
    private String customer;

    private String type;

    private Collection<Item> items = new LinkedHashSet<Item>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}