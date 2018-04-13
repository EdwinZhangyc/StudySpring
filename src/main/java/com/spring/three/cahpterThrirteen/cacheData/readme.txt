第十三章 缓存数据
    本章内容：
        1、启动声明式缓存
        2、使用Ehcache、redis和GemFile实现缓存功能
        3、注解驱动的缓存
    13.1 启用对缓存的支持
        Spring对缓存的支持有两种方式：
            1、注解驱动的缓存
            2、XML声明的缓存
        13.1.1 配置缓存管理器
            Spring3.1 内置了五个缓存管理器的实现：
                1、SimpleCacheManager
                2、NoOpCacheManager
                3、ConcurrentMapCacheManager
                4、CompositeCacheManager
                5、EhCahcheCacheManager
            Spring Data又提供两个缓存管理器：
                1、RedisCacheManager（来自于Spring Data Redis项目）
                2、GemfireCacheManager（来自于Spring Data Gemfire项目）
            使用EhCache缓存
            使用redis缓存
            使用多个缓存管理器
    13.2 为方法添加注解以支持缓存
        13.2.1 填充缓存
            将值放到缓存中
            自定义缓存key
            条件化缓存