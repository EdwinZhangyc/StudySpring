第二十章 使用JMX管理Spring Bean
    本章内容：
        1、将Spring Bean暴露为MBean
        2、远程管理Spring Bean
        3、处理JMX通知
        我们希望深入了解正在运行的应用并要在运行时改变应用的配置，此时就可以使用Java管理扩展（Java Manage-ment Extensions, JMX）.
    20.1 将Spring Bean导出为MBean
        20.1.1 通过名称暴露方法
        20.1.2 使用接口定义MBean的操作和属性
        20.1.3 通过注解驱动的MBean
        20.1.4 处理MBean冲突
    20.2 远程MBean
        20.2.1 暴露远程MBean
        20.2.2 访问远程MBean
        20.2.3 代理MBean
    20.3 处理通知