package com.zyc.test.chapterThree.advancedConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

/**
 * 环境与profile
 */
public class Demo3_1 {

    @Bean (destroyMethod="shutdown")
    public DataSource dataSource () {
        return new EmbeddedDatabaseBuilder()
                .addScript("classpath:schema.sql")
                .addScript("classpath:test-data.sql")
                .build();
    }
}