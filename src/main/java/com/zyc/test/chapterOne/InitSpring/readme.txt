第一章Spring之旅
    本章内容：
        1、Spring的bean容器
        2、介绍Spring的核心模块
        3、更为强大的Spring生态系统
        4、Spring的新功能

    目录：
        1.1.1 激发POJO的潜能
        1.1.2 依赖注入
            /DI功能如何实现的，耦合具有两面性（two-headed beast）紧密耦合的代码难以测试，难以复用、难以理解，容易出现打地鼠式bug，修复一个bug会产生多个bug。
                【Dependency Injection：能够让相互协作的软件组建保持松散的耦合。dependency injection方式之一： constructor injection。
                    在knight包下讲解了使用constructor injection，体现了DI所带来的最大收益-松耦合，使用测试BraveKnightTest测试类中的mock进行验证方法是否被调用一次。
            /将Quest注入到Knight中
                【Config Bean。
                    将Quest注入到Knight中，使用javaConfig（KnightConfig）或是XML(context/chapterOne/Knights.xml)配置方式进行DI依赖注入.
            /观察它是如何工作的
                【测试类KnightMain进行测试（测试包中）测试使用的是xml的配置方式进行测试.
        1.1.3 应用切面
            /Aspect-Oriented Programming:允许你把遍布应用各处的功能分离出来形成可重用的组件。
                【将吟游诗人定义为一个切面，利用AOP可以声明吟游诗人必须歌颂骑士的探险事迹，而骑士本身并不用直接访问Minstrel。使用XML配置切面的方式，在Knights.xml后面追加aop的配置
        1.1.4 使用模版消除样板式代码
            使用模版能够让代码关注自身的职责如JDBCTemplate

      1.2容纳你的Bean
        Spring容器并不只是一个。Spring自带了多个容器的实现，可以归为两种不同的类型。
            1、bean工厂 org.springframework.beans.factory.beanFactory
            2、应用上下文 org.springframework.context.ApplicationContext
        1.2.1 使用应用上下文
            spring 自带了多种类型的应用上下文。下面罗列的几个是你最有可能遇到的 。
                AnnotationConfigAppIicationContext: 从一个或多个基于Java的配置类中加载Spring应用上下文。
                AnnotationConfigWebApplicationContext:从一个或多个基于Java的配置类中加载Spring Web应用上下文。
                ClassPathXmlApplicationContext:从类路径下的一个或多个XML配置文件中加载上下文定义，把应用上下文的定义文件作为类资源 。
                FileSystemxmlApplicationcontext:从文件系统下的一个或多个XML配置文件中加载上下文定义 。
                XmlWebApplicationContext:从Web应用下的一个或多个XML配置文件中加载上下文定义 。
        1.2.2 bean的生命周期
            Java Bean的生命周期很简单，Spring Bean的生命周期很复杂。
      1.3 俯瞰Spring风景线
        1.3.1Spring 模块
            Spring核心
            Spring的Aop模块
            数据访问与集成
            WEB与远程调用
            Instrumentation
            测试
        1.3.2 Spring Portfolio
            Spring Web Flow
            Spring Web Service
            Spring Security
            Spring Integration
            Spring Batch
            Spring Data
            Spring Social
            Spring Mobile
            Spring for Android
            Spring boot

      1.4 Spring的新功能
        Spring3.1，Spring3.2，Spring4.0新特性

      1.5 小结
        Spring致力于简化企业级Java开发，促进代码的松散耦合。成功关键在于DI与AOP。


