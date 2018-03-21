第六章 渲染Web视图
    本章内容：
        1、将模型数据渲染为HTML
        2、使用JSP视图
        3、通过tiles定义视图布局
        4、使用Thymeleaf视图
    6.1 理解视图解析
    6.2 创建JSP视图
        6.2.1 配置适用于JSP的视图解析器
            Spring提供了两种支持JSP视图方式：
                1、如果想让InternalResourceViewResolver将试图解析为JstlView会将视图名解析为JSP，另外如果在JSP页面使用了JavaServer Pages Stanard Tag Library JSTL.如果想让InternalResourceViewResolver将试图解析为JstlView会将视图名解析为JstlView形式的JSP文件。
                2、Spring provide two JSP Tag Library,one 用于表单到model的绑定，另一个provide 通用的工具类特性。
            解析JSTL视图
                如果想让InternalResourceViewResolver将试图解析为JstlView，而不是InternalSourceView的话，只需要设置他的viewClass属性即可，实例见com.spring.two.chapterSix.WebView.resolverJstl
                同时在XML中也可以一样配置
        6.2.2 使用Spring的JSP库
            将表单绑定到模型上
                为了使用表单绑定，需要JSP页面声明：
                    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %> 前缀（prefix）通常也是from
