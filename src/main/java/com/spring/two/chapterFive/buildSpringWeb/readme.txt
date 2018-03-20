第五章 构建Spring Web 应用程序
    本章内容：
        1、映射请求到Spring控制器
        2、透明的绑定表单参数
        3、校验表单提交

    5.1 Spring MVC起步
        Spring将请求在调度Servlet、处理器映射（handler mapping）、控制器以及视图解析器（view resolver）之间移动。
        5.1.1 跟踪Spring MVC的请求
        5.1.2 搭建Spring MVC
            配置DispatcherServlet
                传统方式会将DispatcherServlet配置到web.xml中。servlet3与Spring3.1增强后，就不是唯一的方案了，可以采用Java将DispatcherServlet配置在servlet容器中。
                详情见com.spring.two.chapterFive.buildSpringWeb.buildSpringMVC包下
            两个应用上下文间的故事
            启动Spring MVC
                @EnableWebMvc来创建SpringMVC配置文件，详细配置见WebConfig.java
        5.1.3 Spittr应用简介
    5.2 编写基本的控制器
        5.2.1 测试控制器
            从Spring3.2开始我们可以按照控制器的方式来测试Spring MVC，而不仅仅用POJO进行测试。
            Spring现在包含了一种mock Spring MVC并针对控制器执行HTTP请求机制。这样就没有必要在启动web服务器和Web浏览器了。
            详情见：HomeControllerNewTest.java
        5.2.2 定义类级别的请求处理
            @RequestMapping({"/", "/homepage"})
        5.2.3 传递模型数据到视图中
            详情见com.spring.two.chapterFive.buildSpringWeb.modelDatatoView包下
    5.3 接受请求的输入
        Spring MVC 允许以多种方式将客户端中的数据传送到服务器的处理方法中，包括：
            查询参数（Query parameter）
            表单参数（from parameter）
            路径变量（path Variable）
        5.3.1 处理查询参数
        5.3.2 通过路径参数接受输入
    5.4 处理表单
        详情见com.spring.two.chapterFive.buildSpringWeb.submitForm包下，很重要
        5.4.1 编写处理表单的控制器
        5.4.2 校验表单
    5.5 小结