第九章 保护 Web Application
    本章内容：
        1、Spring Security 介绍
        2、使用Servlet规范中的Filter保护Web应用
        3、基于数据库和LDAP进行认证
    9.1 Spring Security简介
        9.1.1 理解Spring Security的模块
        9.1.2 过滤Web请求
            web.xml中配置Servlet和Filter：
                <filter>
                    <filter-name>SpringSecurityFilterChain</filter-name>
                    <filter-class>
                        org.springframework.web.filter.DelegatingFilterProxy
                    </filter-class>
                </filter>
            JavaConfig：public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer{}
        9.1.3 编写简单的安全性配置
            使用@EnableWebSecurity注解进行启用Web安全性，同时需要将JavaConfig继承WebSecurityConfigurerAdapter
            使用@EnableWebMvcSecurity注解进行启动WebMvc安全性
            为了使Spring Security满足我们的需求，需要添加一些配置：
                1、配置用户存储
                2、指定哪些请求需要认证，哪些请求不需要认证，以及所需要的权限
                3、提供一个自定义的登陆页面，替代原来简单的默认登陆页
    9.2 选择查询用户详细信息的服务
        9.2.1 使用基于内存的用户存储
        9.2.2 基于数据库表进行认证
            重写默认的用户查询功能
            使用转码后的密码
        9.2.3 基于LDAP进行认证
            配置密码比对
            引用远程的LDAP服务器
            配置嵌入式的LDAP服务器
                以上配置均在SecurityConfig.java中
        9.2.4 配置自定义的用户服务
    9.3 拦截请求
        并不是所有的请求都需要进行拦截，过多的拦截反而造成不必要的损失。
        9.3.1 使用Spring表达式进行安全保护
            access()方法
        9.3.2 强制通道安全性
        9.3.3 防止跨站请求伪造
            http.csrf().disable();//禁用CSRF防护功能，需要慎重使用
    9.4 认证用户
        9.4.1 添加自定义的登陆页
        9.4.2 启动HTTP Basic认证
        9.4.3 启动Remember-me功能
            单点登陆：只登陆一次，所有站点就不用再次登陆了
        9.4.4 退出
    9.5 保护视图
        9.5.1 使用Spring Security的JSP标签库


