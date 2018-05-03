本章内容：
    Spring Profile
    条件化的bean声明
    自动装配与歧义性
    bean的作用域
    Spring表达式语言

    3.1 环境与Profile
        场景：项目具有多个环境如：开发，SIT，UAT，准生产，生产环境，压力测试，QA环境等，每一套环境都有不同的数据库配置，加密算法，第三方系统地址都有所不同。这样就导致了非常繁琐的多个profile。
        3.1.1 配置 profile bean（Spring3.1）
            JavaConfig中使用@Profile注解指定某个bean属于哪一个profile。没有指定profile的bean会始终创建，与激活哪个profile没有关系。
            在XML中配置Profile：
                使用方式：<beans profile="dev"/>
        3.1.2 激活Profile
           激活Profile需要两个独立的属性：spring.profiles.active > spring.profiles.default  优先级active高，如果两个属性都没有设置值，则只会创建那些没有profile的bean
           有多种方式来设置这两个属性：
                作为DispatcherServlet的初始化参数
                作为web应用的上下文参数
                作为JNDI条目
                作为环境变量
                作为JVM系统属性
                在集成测试类上，使用@ActiveProfiles注解设置
                本项目中采用DispatcherServlet的参数将spring.profiles.default设置为开发环境profile。在web.xml中进行配置。并且可以同时激活多个profile，并且以逗号分割
           使用profile进行测试
                在测试类中使用@ActiveServlet("dev")注解进行测试不同的profile
    3.2 条件化的bean
        Spring4.0提供了@Conditional注解，在@Bean上使用
    3.3 处理自动装配的歧义性
        场景：当一个接口有多个实现类，并且其他bean在injection时没有指定injection哪个实现类，这时会产生异常。解决方式有下面几种：
        3.3.1 标示首选的beana()
            使用@Primary注解  当使用AutoWiring时放在@Component下 当使用JavaConfig时放在@Bean上 当使用XML时<bean id="" class="" primary="true">
        3.3.2 限定自动装配的bean
            当@Primary注解同时使用在多个bean时，则失效，需要使用限定自动装配的bean。
            @Qualifier注解是使用限定符的主要方式，它可以与@Autowired和@Inject注解  组合使用
            创建自定义的限定符
                将@Qualifier注解与@Component  或是JavaConfig中的@Bean注解组合使用，@Qualifier("test")注解的别名与注入时别名一致即可。
            使用自定义的限定符注解
                @Qualifier注解可以给一个bean加标识（可以想象为标签），但是当多个bean公用这个标签时，spring又不知道该注入哪一个bean了，这时我们可以在一个bean上
                  加多个标签以便使bean的标示唯一，但是java不允许在同一个条目上重复出现相同类型的多个注解
                （java8允许出现重复的注解，只要这个注解在定义时带有@Repeatable注解即可，但是spring得@Qualifier注解在定义时并没有添加@Repeatable注解）
                此时我们可以使用自定义注解的方式来完美化解，实例在customQualifier包下
                口述难理解的话，可以查看spring实战3.3整节即可。
    3.4 bean的作用域
        spring定义了多种作用域，可以基于这些作用域创建bean，包括：
            单例（Singleton）：在整个应用中，只创建bean的一个实例。
            原型（Prototype）：每次注入或者通过spring应用上下文获取的时候，都会创建一个新的bean实例。
            会话（Session）：在web应用中，为每个会话创建一个bean实例。
            请求（Request）：在web应用中，为每个请求创建一个bean实例。

            单例是默认的作用域，如果想要切换到其他作用域则使用@Scope注解，它可以与@Component组合使用，在JavaConfig中可以与@Bean组合使用，使用XML时<bean id="" class="" scope="prototype"/>
            如：@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) = @Scope("prototype") 但是SCOPE_PROTOTYPE更加安全 实例：Notepad.java
        3.4.1 使用会话和请求作用域
            没太理解什么意思，基于代理之类。
        3.4.2 在XML中声明作用域代理
    3.5 运行时植入
        Spring 提供两种在运行时求值得方式：
            属性占位符（Property placeholder）
            spring expression language
        3.5.1 注入外部的值
            在JavaConfig中使用@PropertySource("classpath:config/chapterThree/test.properties")，与Environment的使用
            深入学习Spring的Environment
                可以指定默认值，以及返回数据的类型，详情见3.5.1
            解析属性占位符
                属性占位符形式${...}
        3.5.2 使用Spring Expression Language 进行wiring
            SpEL有很多特性，包括：
                使用bean的ID来引用bean
                调用方法和访问对象的属性
                对值进行算数、关系和逻辑运算
                正则表达式匹配
                集合操作
            SpEL样例：
                SpEL表达式要放到#{...}中，与属性占位符${...}很相似，但是不一样，引用系统变量#{systemProperties['test']}
                表示字面值
                    #{1}
                引用bean、属性和方法
                在表达式中使用类型
                    #{T(java.lang.Math).PI}
                SpEL运算符
                    #{disc.title ?: '如果disc.title值为空则显示我，三木运算'}
                计算正则表达式
                    #{admin.mail mathes '[a-z].....'}
                计算集合
                    这个地方理解的也不透彻，需要后期多做练习
    3.6 小结
        本章所讲内容还是较为丰富，进一步做bean高级配置，要多多练习，还有几处不理解的地方，后期慢慢理解。




