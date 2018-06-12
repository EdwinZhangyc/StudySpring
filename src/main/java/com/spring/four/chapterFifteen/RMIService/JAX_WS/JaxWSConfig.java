package com.spring.four.chapterFifteen.RMIService.JAX_WS;

import com.spring.four.chapterFifteen.RMIService.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

import java.net.MalformedURLException;
import java.net.URL;

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
    //调用
    @Bean
    public JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean(){
        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
        URL url = null;
        try {
            url = new URL("http://localhost:8080/services/SpitterService?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        proxy.setWsdlDocumentUrl(url);
        proxy.setServiceName("SpitterService");
        proxy.setPortName("spitterServiceHttpPort");
        proxy.setServiceInterface(SpitterService.class);
        proxy.setNamespaceUri("http://spitter.com");
        return proxy;
    }
}