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