第二章 在Spring中使用DI装配对象：
    本章内容：
        1、声明bean
        2、构造器注入和setter方法注入
        3、装配bean
        4、控制bean的创建和销毁
    2.1 Spring配置方案，使用DI装配对象（bean装配技术）
        1、隐式的bean发现机制和autowiring(强烈推荐使用)
            显示配置越少越好。
        2、在java中进行显示配置JavaConfig（第二推荐）
            类型安全且比xml更加强大。
        3、在XML中进行显示配置（不推荐）
            只有在你想要使用便利的XML命名空间且在JavaConfig中没有同样实现时使用。
    2.2 自动化配置bean
         Spring从两个角度来实现自动化装配 ：
            组件扫描（component scanning）：spring会自动发现应用上下文中所创建的bean 。
            自动装配（autowiring）：Spring自动满足bean之间的依赖 。
        2.2.1 创建可被发现的bean
            该自动化配置的代码在com.zyc.text.chapterTwo.configBean.autowiring下，里面包括测试类及配置类。
        2.2.2 为组件扫描的包名称
            @Component ("abc")约等于@Named("abc")  默认类名首字母小写
        2.2.3 设置组件扫扫描的基础包
            可以设置一个空的mark interface，也可以将配置类写在根目录下，这样自动扫描会扫描根路径及以下所有的子包
        2.2.4 通过为bean添加注解实现AutoWiring
            构造器，setter或是其他赋值方法都可以使用@AutoWired 约等于 @Inject 注解
            @AutoWired(required=false)时，Spring会尝试执行自动装配，但是如果没有匹配的bean的话，Spring会让这个bean处于未装配状态。但是需要谨慎对待，如果代码没有进行null检查，会报空指针异常。
        2.2.5 验证AutoWiring
    2.3 通过Java代码显示装配bean
        1、通过javaConfig显示的配置Spring：创建JavaConfig类的关键在于为其添加@Configuration注解，他表明了这是一个配置类。
        2、隐式配置（自动化配置bean），在javaConfig类中添加@ComponentScan注解即可。2.2.3设置扫描路径
小结：第二章讲述的内容不算复杂，就是spring的三种配置方案，以及混合配置，有时间可以每种方案都进行一次配置项目实践。