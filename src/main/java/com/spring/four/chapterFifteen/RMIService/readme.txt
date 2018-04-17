第十五章 使用远程服务
    本章内容：
        1、访问和发布RMI服务
        2、使用Hessian和Burlap服务
        3、使用Spring的HTTP invoker
        4、使用Spring开发Web服务
        我们有多种远程调用技术，包括：
            1、远程方法调用（Remote Method Invacation, RMI）
            2、Caucho的Hession和Burlap
            3、Spring基于Http的远程服务
            4、使用JAX-RPC和JAX-WS的Web Service
    15.1 Spring远程调用概括
        Spring通过多种远程调用技术支持RPC
            远程方法调用（RMI）：不考虑网络限制时（例如防火墙），访问/发布基于Java的服务。
            Hessian或Burlap：考虑网络限制时，通过Http访问/发布基于Java的服务。Hessian是二进制协议。而Burlap是基于XML的。
            HTTP invoker：考虑网络限制，并希望使用基于XML或专有序列化机制实现Java序列化时，访问/发布基于Spring的服务。
            JAX-RPC和JAX-WS：访问/发布平台独立、基于SOAP的Web服务。
    15.2 使用RMI（Remote Method Invacation）
        15.2.1 导出RMI服务
            Spring中配置RMI服务
    15.3 使用Hessian和Burlap发布远程服务
        15.3.1 使用Hessian和Burlap导出bean功能
            导出Hessian服务
            配置Hessian控制器
                Hessian,Burlap,HttpInvoker,由于基于http的所以都需要将ServiceExporter声明为Spring MVC控制器。需要两个额外配置
                    1、在web.xml中配置Spring的DispatcherServlet，并把我们的应用发布为一个web项目。
                    2、在Spring的配置文件中配置一个URL处理器，把Hessain服务的URL分发给对应的Hessian服务bean。
                配置Spring的DispatcherServlet有三种方式，1、在web.xml中进行配置，2、
            导出Burlap服务
        15.3.2 访问Hessian/Burlap服务
    15.4 使用Spring的HttpInvoker
        15.4.1 将bean导出为HTTP服务
        15.4.2 通过HTTP访问服务
    15.5 发布和使用Web服务
        15.5.1 创建基于Spring的JAX-WS端点
            Spring自动装配JAX-WS端点
                使用@WebService注解所标注的类被认为Web服务的端点。
                使用@WebMethod注解所标注的方法被认为是操作。
            导出独立的JAX-WS端点
        15.5.2 在客户端代理JAX-WS服务
