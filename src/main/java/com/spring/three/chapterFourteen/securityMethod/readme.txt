第十四章 保护方法应用
    本章内容：
        1、保护方法调用
        2、使用表达式定义安全规则
        3、创建安全表达式计算器
    14.1 使用注解保护方法
        Spring Security提供了三种不同的注解
            1、Spring Security自带的@Secured注解
            2、JSR-250的@RolesAllowed注解
            3、表达式驱动的注解，包括@PreAuthorize、@PostAuthorize、@PreFilter和@PostFilter
         14.1.1 使用@Secured注解限制方法调用
            在spring中，如果要启用基于注解的方法安全性，关键之处在于在配置类上使用@EnableGlobalMethodSecurity注解,同时继承GlobalMethodSecurityConfiguration
         14.1.2 在Spring Security中使用JSR-250的@RolesAllowed注解
    14.2 使用表达式实现方法级别的安全性
        Spring Security3.0 提供了4个新的注解，可以使用SpEL表达式来保护方法调用
        @PerAuthorize:在方法调用之前，基于表达式的计算结果来限制对方法的调用
        @PostAuthorize：允许方法调用，但是如果表达式计算结果为false，将抛出一个安全性异常
        @PostFilter：允许方法调用，但必须按照表达式来过滤方法的结果
        @PreFilter：允许方法调用，但必须在进入方法之前过滤输入值
        14.2.1 表述方法访问规则
            在方法调用前验证权限
            在方法调用之后验证权限（调用后发现不满足权限则抛出异常）
                该注解使用较少，使用场景：例如需要从数据库中查询出对象在判断是否属于当前用户时使用。
        14.2.2 过滤方法的输入与输出
            事后对方法的返回值进行过滤
                使用场景：当管理员与用户操作，用户操作时将用户本身的数据返回，管理员操作将所有的返回
            事先对方法的参数进行过滤
            定义许可计算器（permission evaluator）