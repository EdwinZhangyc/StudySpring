第十一章 使用对象-关系映射持久化数据
    本章内容：
        1、使用Spring和Hibernate
        2、借助上下文Session，编写不依赖于Spring的Repository
        3、通过Spring使用JPA（Java Persistence API）Java持久化API
        4、借助Spring Data实现自动化的JPA Repository
    Spring对ORM框架的支持提供了与这些框架的集成点以及一些附加的服务：
        1、支持集成Spring声明式事物
        2、透明的异常处理
        3、线程安全的、轻量级的模板类
        4、DAO支持类
        5、资源管理
    11.1 在Spring中继承Hibernate
        11.1.1 声明Hibernate的Session工厂
        11.1.2 构建不依赖于Spring的Hibernate代码
    11.2 Spring And Java Persistence API
        11.2.1 Config Entity Manager Factory
            config application manager type JPA(Java Persistence API)
            use container manager type Java Persistence API
            从JDNI获取entity manager factory
        11.2.2 编写基于JPA的Repository
    11.3 借助Spring Data实现自动化的JPA Repository
        public interface SpitterRepositorySpringData extends JpaRepository<Spitter, Long>
        xml:<jpa:repositories base-package="com.spring.three.chapterEleven.relationalMapping"/>
        JavaConfig:@EnableJpaRepositories(basePackages = "com.spring.three.chapterEleven.relationalMapping")
        11.3.1 定义查询方法
            Spring Data 定义了一组小型的领域特定语言（domain-specific language, DSL）
            Repository方法是由一个动词（read），一个可选主题（subject），关键词（by）以及一个断言组成。
            几个符合方法命名约定的方法签名：
                List<Pet> findPetsByBreedIn(List<String> breed)
                int countProductsByDiscontinueedTrue()
                List<Order> findByShippingDateBetween(Date start, Date end)
        11.3.2 声明自定义查询
        11.3.3 混合自定义功能
    11.4 小结