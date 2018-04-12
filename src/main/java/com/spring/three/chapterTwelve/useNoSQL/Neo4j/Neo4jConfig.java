package com.spring.three.chapterTwelve.useNoSQL.Neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;

/**
 * 程序清单12.8 使用@EnableNeo4jRepositories配置Spring Data Neo4j
 * 需要继承 Neo4jConfiguration
 */
@Configuration
//启动Repository自动生成功能
@EnableNeo4jRepositories(basePackages = "com.spring")
public class Neo4jConfig extends Neo4jConfiguration {

    //设置模型基础包
    public Neo4jConfig(){
        setBasePackage("orders");
    }

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService grapDatabaseService(){

        return new GraphDatabaseFactory()
                .newEmbeddedDatabase("/tmp/graphdb");//配置嵌入式数据库
    }
    /**
     * 当数据库在远程同时需要提供凭证
     */
    //@Autowired
    //Environment environment;
    //@Bean(destroyMethod = "shutdown")
    //public GraphDatabaseService grapDatabaseService(Environment environment){
    //    return new SpringRestGraphDatabase(
    //            "http://graphdbserver:7474/db/data/",
    //            environment.getProperty("db.username"),
    //            environment.getProperty("db.password")
    //    );
    //}

}