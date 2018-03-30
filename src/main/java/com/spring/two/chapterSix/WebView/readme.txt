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
            展现错误
                <sf:errors path="firstName" cssClass="error"/>  详情见/WEB-INF/viewsChapterSix/registerForm.jsp
                同时在后台添加校验表单，以及校验失败后提示的信息，同时对不同浏览器国家语言，展现不同的报错语言信息
            Spring通用标签库
                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            展现国际化信息
            创建URL
            转义内容
    6.3 使用Apache Tiles 视图定义布局
        适用于所有页面的通用页面布局
        6.3.1 配置Tiles视图解析器
            需要配置两个bean，一个是TilesConfigurer，一个是TilesViewResolver 同时可以使用xml就行配置
            定义Tiles（布局）
                详情见layout下配置。
    6.4 使用Thymeleaf
        6.4.1 配置Thymeleaf视图解析器
            为了要在Spring中使用Thymeleaf:我们需要配置三个启动Thymeleaf与Spring集成的bean
                1、ThymeleafViewResolver:将逻辑视图名称解析为Thymeleaf模板视图
                2、SpringTemplateEngine:处理模板并渲染结果
                3、TemplateResolver:加载Thymeleaf的支持
        6.4.2 定义Thymeleaf模板