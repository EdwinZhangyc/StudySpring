第七章 Spring MVC的高级技术
    本章内容：
        Spring MVC配置的替代方案
        处理文件上传
        在控制器中处理异常
        使用flash属性
    7.1 Spring MVC配置的替代方案
        7.1.1 自定义 DispatcherServlet 配置
        7.1.2 添加其他的Servlet和Filter
        7.1.3 在web.xml中声明DisptcherServlet，加载@Configuration的JavaConfig
            详细配置见com.spring.two.chapterSeven.advancede.customDispatcher包下的web.xml配置
    7.2 处理multipart形式的数据
        7.2.1 配置multipart解析器
            使用servlet3.0解析multipart请求（经常使用，使用与servlet3.0）
                使用JavaConfig的方式见com.spring.two.chapterSeven.advancede.customDispatcher.WebInitializer类
                使用xml方式见com.spring.two.chapterSeven.advancede.customDispatcher包下的web.xml配置
                同时需要在配置类中就行配置，详情见com.spring.two.chapterSeven.advancede.customDispatcher.WebConfig中的配置
            配置Jakarta Commons FileUpLoad multipart 解析器（当使用非servlet3.0时使用）
                通过设置uploadTempDir属性，指定上传文件的位置，默认是servlet容器的临时目录
                同时可以限制multipart上传文件大小，与MultiprtConfigElement不同，不可以设置multipart整体的最大容量
        7.2.2 处理nultipart请求
            在控制器上添加@RequestPart注解，使用方式@RequestPart("profilePicture") byte[] profilePicture,  在接受的方法参数上添加
            接受multipartFile
            将文件保存到Amazon S3中
