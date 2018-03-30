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
            以part的形式接受上传的文件
    7.3 处理异常
        Spring提供了多种方式将异常转换为响应：
            1、特定的Spring异常将会自动映射为指定的HTTP状态码。
            2、异常上可以添加@ResponseStatus注解，从而将其映射为某一个HTTP状态码。
            3.在方法上添加@ExceptionHandler注解，使其用来处理异常。
        7.3.1 将异常映射为HTTP状态码
            使用@ResponseStatus注解来完成相应的操作，详情见SpittleNotFoundException.java
        7.3.2 编写异常处理方法
            如果出现了某异常则执行某方法，使用@ExceptionHandler注解注释方法来实现完成com.spring.two.chapterSeven.advancede.customDispatcher.SpittleController.java中的handleDuplicateSpittle方法
    7.4 为控制器添加通知
        以上所述是同一个控制器下可以进行捕获异常，但是有没有办法使所有的控制器使用同一捕获异常的方法呢，有两种解决的方式：
            1、使所有的控制器继承同一父类，从而继承@ExceptionHandler方法
            2、使用@ControllerAdvice  详情见AppWideExceptionHandler.java
    7.5 跨重定向请求传递参数
        对于重定向来说，模型并不能够用来传递数据。但我们也有一些其他方案，能够从发起重定向的方法传递数据给处理重定向的方法中。
            1、使用URL模板以路径变量或是查询参数的形式进行传递参数(缺点：不能进行传递复杂的值，如传递对象)
            2、通过flash属性发送数据
        7.5.1 通过URL模板进行重定向
            Model  model   model.addAttribute(key,value)/或"redirect:spitter/{username}"
        7.5.2 使用flash属性
            RedirectAttributes model model.addFlashAttribute("spitter", spitter);
    7.6 小结
