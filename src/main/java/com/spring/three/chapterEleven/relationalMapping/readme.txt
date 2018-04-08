第十一章 使用对象-关系映射持久化数据
    本章内容：
        1、使用Spring和Hibernate
        2、借助上下文Session，编写不依赖于Spring的Repository
        3、通过Spring使用JPA（Java Persistence API）Java持久化API
        4、借助Spring Data实现自动化的JPA Repository
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
        11.3.1 定义查询方法
        11.3.2 声明自定义查询
        11.3.3 混合自定义功能
    11.4 小结