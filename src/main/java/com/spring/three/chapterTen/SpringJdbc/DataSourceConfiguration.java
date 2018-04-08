package com.spring.three.chapterTen.SpringJdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * 程序清单10.2 借助Spring的profile特性能够在运行时选择数据源
 */
@Configuration
public class DataSourceConfiguration {

    @Profile("Development")
    @Bean
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema-sql")
                .addScript("classpath:test-data.sql")
                .build();

    }

    @Profile("QA")
    @Bean
    public DataSource Data() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("org.h2.driver");
        basicDataSource.setUrl("jdbc:hs:tcp://localhost/~/spitter");
        basicDataSource.setUsername("test");
        basicDataSource.setPassword("yesy");
        basicDataSource.setInitialSize(5);
        return basicDataSource;
    }

    @Profile("Production")
    @Bean
    public DataSource dataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/SpitterDs");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return (DataSource) jndiObjectFactoryBean.getObject();
    }
}