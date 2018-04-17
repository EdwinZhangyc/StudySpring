package com.spring.four.chapterFifteen.RMIService.config;

import com.spring.four.chapterFifteen.RMIService.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class JaxWSConfig {

    //JAX-WS发布服务
    @Bean
    public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter(){

        SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
        //可以设置地址与端口号
        exporter.setBaseAddress("http://localhost:8888/services/");
        return exporter;
        //new SimpleJaxWsServiceExporter().setBaseAddress("http://localhost:8888/services/");
    }

    //客户端代理JAX-WS服务
    @Bean
    public JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean(){
        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
        //proxy.setWsdlDocument("http://localhost:8080/services/SpitterService?wsdl");
        proxy.setServiceName("SpitterService");
        proxy.setPortName("spitterServiceHttpPort");
        proxy.setServiceInterface(SpitterService.class);
        proxy.setNamespaceUri("http://spitter.com");
        return proxy;
    }
}