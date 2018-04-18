第十六章 使用Spring MVC创建REST API
    本章内容：
        1、编写处理REST资源的控制器
        2、以XML、JSON及其他格式来表述资源
        3、使用REST资源
        SOAP一般会关注行为和处理，而REST（Representational State Transfer表述行状态转移）关注的是要处理的数据。
    16.1 了解REST
        16.1.1 REST的基础知识
            RPC是面向服务的，并关注于行为和动作。
            REST是面向资源的，强调描述应用程序的事物和名词。
            REST中会有行为，他们是通过HTTP方法来定义的,以下是CRUD操作：
                create:POST
                Read:Get
                Update:PUT或PATCH
                Delete:DELETE
        16.1.2 Spring是如何支持REST的
    16.2 创建第一个REST端点
        Spring提供啦两种方法将资源的Java表述形式转换为发送给客户端的表述形式：
            内容协商（content negotiation）：选择一个视图，它能够将模型渲染为呈现给客户端的表述形式。
            消息转换器（Message Conversion）：通过一个消息转换器将控制器所返回的对象转换为呈现给客户端的表述形式。
        16.2.1 协商资源表述
            使用Spring的ContentNegotitatingViewResolver特殊视图解析器，这涉及内容协商的两个步骤：
                1、确定请求的媒体类型
                2、找到合适请求媒体类型的最佳视图
            确定请求的媒体类型
            影响媒体类型的选择
            ContentNegotiatingViewResolver优势与限制
        16.2.2 使用HTTP信息转换器
            在响应体中返回资源状态
            在请求体中接收资源状态
            为控制器默认设置消息转换
    16.3 提供资源之外的其他内容
        16.3.1 发送错误信息到客户端
            使用ResponseEntity
            处理错误
        16.3.2 在响应中设置头部信息
    16.4 编写REST客户端
        16.4.1 了解RestTemplate的操作
        16.4.2 GET资源
        16.4.3 检索资源
        16.4.4 抽取响应的元数据
        16.4.5 PUT资源
        16.4.6 DELETE资源
        16.4.7 POST资源数据
        16.4.8 在POST请求中获取响应对象
        16.4.9 在POST请求后获取资源位置
        16.4.10 交换资源