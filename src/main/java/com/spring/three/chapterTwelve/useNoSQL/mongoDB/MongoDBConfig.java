package com.spring.three.chapterTwelve.useNoSQL.mongoDB;


import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * 程序清单12.1 Spring Data MongDB的必要配置
 * 程序清单12.2 借助继承AbstractMongoDBConfiguration，实现Spring Data MongDB的必要配置，使程序更加简洁
 */
@Configuration
//启用MongoDB的Repository功能
@EnableMongoRepositories(basePackages = "com.spring.three.chapterTwelve.useNoSQL")
public class MongoDBConfig extends AbstractMongoConfiguration{

    @Override
    protected String getDatabaseName() {
        return "OrdersDB";//指定数据库名称
    }

    /**
     * 程序清单 12.3 创建MonoDBClient来访问需要认证的MongDB服务器
     * @return
     * @throws Exception
     */
    @Autowired
    private Environment env;
    @Override
    public Mongo mongo () throws Exception {
        MongoCredential credential = MongoCredential.createMongoCRCredential(
                //创建MongoDB凭证
                env.getProperty("mongo.username"),
                "OrdersDB",
                env.getProperty("mongo.password").toCharArray()
        );
        return new MongoClient(
                new ServerAddress("localhost", 37017),
                Arrays.asList(credential)
        );//创建Mongo客户端
    }

  /*  *//**
     * MongoDBClient bean
     * 与关系型数据库的DataSource的作用没有什么区别
     * 与MongoDB数据库建立连接
     *//*
    @Bean
    public MongoFactoryBean mongo() {
        MongoFactoryBean mongoFactoryBean = new MongoFactoryBean();
        mongoFactoryBean.setHost("localhost");
        return mongoFactoryBean;
    }

    *//**
     * MongoTemplate bean
     *//*
    @Bean
    public MongoOperations mongoTempalte(Mongo mongo){
        return new MongoTemplate(mongo, "OrdersDB");//指定数据库名称
    }*/
}