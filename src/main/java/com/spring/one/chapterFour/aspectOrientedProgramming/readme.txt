第四章 面向切面的Spring
    本章内容：
        1、面向切面的基本原理
        2、通过POJO创建切面
        3、使用@AspectJ注解
        4、为AspectJ切面注入

    4.1 什么是面向切面编程
        如果要重用通用功能的话，最常见的面向对象技术是继承（inheritance）或委托。但是如果在整个应用程序中都使用同一个基类，继承往往会导致一个脆弱的对象体系。而使用委托可能需要对委托对象进行复杂调用。
        切面提供了取代继承和委托的另一种可行方案。
        4.1.1 定义AOP术语
            通知（advice）
                切面的工作被称为advice。
                Spring切面可以应用5中类型的通知：
                    1、前置通知（Before）：在目标方法被调用之前调用通知功能。
                    2、后置通知（After）：在目标方法被调用之后调用通知功能。此时不会关心方法的输出是什么。
                    3、返回通知（After-returnning）：在方法成功执行之后调用通知。
                    4、异常通知（After-throwing）：在方法抛出异常后调用通知。
                    5、环绕通知（Around）：通知包裹了被通知的方法，在被通知的方法调用之前和调用之后执行自定义的行为。
            连接点（join point）
                我们的应用可能有数以千计的时机应用通知，这些时机被称为连接点。通俗的来讲可以想象为一个类中有很多地方可以进行切入，这些地方就是join point
            切点（pointcut）
                如果说通知定义了切面的”什么“ 和 ”何时“的话，切点定义的就是何处了。
            切面（Aspect）
                Aspect是pointcut与advice的结合。
            引入（introduction）
                无需修改现有的类，让他们具有新的行为和状态。
            织入（Weaving）
        4.1.2 Spring对AOP的支持
            Spring提供了四种类型的AOP支持：
                1、基于代理的经典Spring AOP（没有介绍，过于繁琐对于现在而言）
                2、纯POJO切面（这种技术需要XML配置）
                3、@AspectJ注解驱动的切面
                4、注入式AspectJ切面（适用任何版本的Spring）
            Spring通知是Java编写的
            Spring在运行时通知对象
            Spring只支持方法级别的连接点
    4.2 通过切点来选择连接点
        只有execution指示器是实际执行匹配的，而其他指示器都是用来限制匹配的。execution是我们编写切点定义最主要的指示器，在此基础上，我们使用其他指示器来限制所匹配的切点。
        4.2.1 编写切点
            定义切点：execution(* Performance.perfrom(..))
            使用其他指示器：execution(* Performance.perfrom(..)) && within(com.*)
        4.2.2 在切点中选择bean
            execution(* Performance.perfrom()) and !bean('woodstock')
    4.3 使用注解创建切面JavaConfig
        使用注解创建切面是AspectJ5所引入的新特性。
        4.3.1 定义切面
            @Aspect 声明切面 @Before @After @AfterReturning @AfterThrowing @Around 代码配置见aspect包下
            在JavaConfig中使用@EnableAspectJAutoProxy注解启动AspectJ自动代理功能
            在XML配置中使用<aop:aspectj-autoproxy/>来声明AspectJ自动代理功能
        4.3.2 环绕通知（around advice）
            around advice 能够让你编写的逻辑将被通知的目标方法完全封装起来。实际上就像是在一个通知方法中同时编写前置通知和后置通知
            @Around 需要与ProceedingJoinPoint 组合使用，实例请看AduienceUpgradeAround.java
        4.3.3 处理通知中的参数
            execution(* com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc.play(int)) && args(trackNumber)
            详情实例见notifyParameter包下
        4.3.4 通过注解引入新功能
    4.4 在XML中声明切面
        原则：基于注解的配置要优于基于java的配置，基于java的配置要优于基于XML的配置。
        场景：需要声明的切面又不能为通知类添加注解时，就必须使用XML配置类。
        4.4.1 声明前置通知和后置通知
        4.4.2 声明Around advice
        4.4.3 为通知传递参数
        4.4.4 通过切面引入新的功能
    4.5 注入AspectJ切面
    4.6 小结

