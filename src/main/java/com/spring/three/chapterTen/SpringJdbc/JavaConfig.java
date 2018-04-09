package com.spring.three.chapterTen.SpringJdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * 程序清单10.2 借助Spring的profile特性能够在运行时选择数据源
 */
@Configuration
public class JavaConfig {


    /**
     * 使用jdbcTemplate进行数据的增删该查
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate (DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 配置jndi数据源
     * @return
     */
    @Profile("Production")
    @Bean
    public JndiObjectFactoryBean dataSource() {

        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/Spitter");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return  jndiObjectFactoryBean;
    }

    /**
     * 使用开源框架数据源连接池配置DBCP
     */
    @Profile("QA")
    @Bean
    public BasicDataSource DBCPdataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setInitialSize(5);
        basicDataSource.setPassword("dm");
        basicDataSource.setDriverClassName("org.h2.Driver");
        basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/spitter");
        basicDataSource.setUsername("dm");
        return basicDataSource;
    }

    /**
     * 基于JDBC驱动的数据源
     */
    @Profile("Development1")
    @Bean
    public DataSource JdbcDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        driverManagerDataSource.setUrl("jdbc:h2:tcp://localhost/~/spitter");
        driverManagerDataSource.setUsername("dm");
        driverManagerDataSource.setPassword("dm");
        return driverManagerDataSource;
    }
    /**
     * embedded database
     */
    @Profile("Development2")
    @Bean
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("com/spring/three/chapterTen/SpringJdbc/schema.sql")
                .addScript("classpath*:config/test-data.sql")
                .addScripts("com/spring/three/chapterTen/SpringJdbc/schema.sql", "classpath*:config/test-data.sql")
                .build();
    }
}
