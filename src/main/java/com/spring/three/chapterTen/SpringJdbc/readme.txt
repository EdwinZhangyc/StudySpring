第十章 通过Spring和JDBC征服数据库
    本章内容：
        1、定义Spring对数据访问的支持
        2、配置数据库资源
        3、使用Spring的JDBC模版
    10.1 Spring 的数据访问哲学
        10.1.1 了解Spring的数据访问异常
            Spring所提供的平台无关的持久化异常
            不用写catch代码块
                Spring异常都继承自DataAccessException，它是一个非检查型异常。
        10.1.2 数据访问模板化
    10.2 配置数据源
        Spring提供了在Spring上下文中配置数据源bean的多种方式，包括：
            1、通过JDBC驱动程序定义的数据源
            2、通过JNDI查找数据源
            3、连接池的数据源
        10.2.1 使用JNDI数据源
        10.2.2 使用数据库连接池
        10.2.3 基于JDBC驱动的数据源
        10.2.4 使用嵌入式的数据源
            每次重启或是运行测试时，都会重新填充测试数据（多用于开发，测试环境）
        10.2.5 使用profile选择数据源
    10.3 在Spring中使用JDBC
        10.3.1 应对失控的JDBC代码
        10.3.2 使用JDBC模板
            使用JdbcTemplate来插入数据
            使用JdbcTemplate来读取数据
            在JdbcTemplate中使用Java8的Lambda表达式
            使用命名参数
    10.4 小结