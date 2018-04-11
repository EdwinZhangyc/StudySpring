package com.spring.three.chapterEleven.relationalMapping;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.spring.three.chapterEleven.relationalMapping")
public class JavaConfig {

    /**
     * JPA配置
     */
    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalEntityManagerFactoryBean localEntityManagerFactoryBean = new LocalEntityManagerFactoryBean();
        //名字为persistence.xml的持久化单元的名称
        localEntityManagerFactoryBean.setPersistenceUnitName("spitterPU");
        return localEntityManagerFactoryBean;
    }

    /**
     * 使用容器管理类型的JPA
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
    (DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){

        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean
                = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource);
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.spring.three.chapterEleven.relationalMapping.domain");
        return  localContainerEntityManagerFactoryBean;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        //hibernateJpaVendorAdapter.setDatabase("HSQL");
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(false);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernateJpaVendorAdapter");
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor (){
        return new PersistenceAnnotationBeanPostProcessor();
    }

    /**
     * 转化异常
     * @return
     */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


    /**
     * 使用hibernate3.2以上版本不包括4.0并且使用XML定义映射
     */
    //@Bean
    //public LocalSessionFactoryBean sessionFactory (DataSource dataSource){
    //    LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean ();
    //    localSessionFactoryBean.setDataSource(dataSource);
    //    localSessionFactoryBean.setMappingResources(new String[] {"Spitter.hbm.xml"});
    //    Properties properties = new Properties();
    //    properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
    //    localSessionFactoryBean.setHibernateProperties(properties);
    //    return localSessionFactoryBean;
    //}

    /**
     * 使用hibernate3.2以上版本不包括4.0并且使用JavaConfig定义映射
     */
    @Bean
    public AnnotationSessionFactoryBean sessionFactoryBean(DataSource dataSource) {
        AnnotationSessionFactoryBean annotationSessionFactoryBean = new AnnotationSessionFactoryBean();
        annotationSessionFactoryBean.setDataSource(dataSource);
        annotationSessionFactoryBean.setPackagesToScan(new String[] {"com.spring.three.chapterEleven.relationalMapping.domain"});
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        annotationSessionFactoryBean.setHibernateProperties(properties);
        return  annotationSessionFactoryBean;
    }

    /**
     * 如果使用Hibernate4
     */
    public LocalSessionFactoryBean sessionFactoryHibernate4 (DataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean ();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan(new String[] {"com.spring.three.chapterEleven.relationalMapping.domain"});
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        localSessionFactoryBean.setHibernateProperties(properties);
        return localSessionFactoryBean;
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