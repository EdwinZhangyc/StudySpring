第十二章 使用NoSQL数据库
    本章内容：
        1、为MongoDB和Neo4j编写Repository
        2、为多种数据存储形式持久化数据
        3、组合使用Spring与Redis
    12.1 使用MongoDB持久化文档数据
        Spring Data MongoDB提供了三种方式在Spring中使用MongoDB
            1、通过注解实现对象-文档映射
            2、使用MongoDBTemplate实现基于模板的数据库访问
            3、自动化的运行时Repository生成功能。