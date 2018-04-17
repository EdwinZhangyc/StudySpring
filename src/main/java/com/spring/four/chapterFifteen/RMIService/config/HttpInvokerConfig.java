package com.spring.four.chapterFifteen.RMIService.config;

import com.spring.four.chapterFifteen.RMIService.SpitterService;
import com.spring.four.chapterFifteen.RMIService.domain.Spitter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@Configuration
public class HttpInvokerConfig {

    //发布服务
    @Bean
    public HttpInvokerServiceExporter httpInvokerServiceExporter(SpitterService spitterService){
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setService(spitterService);
        exporter.setServiceInterface(SpitterService.class);
        return exporter;
    }

    //请求转接
    @Bean
    public HandlerMapping handlerMapping(){

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties properties = new Properties();
        properties.setProperty("/spitter.service", "httpInvokerServiceExporter");
        mapping.setMappings(properties);
        return  mapping;
    }

    //请求服务
    public HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean(){
        HttpInvokerProxyFactoryBean proxyFactoryBean = new HttpInvokerProxyFactoryBean();
        proxyFactoryBean.setServiceUrl("http://localhost:8080/Spitter/spitter.service");
        proxyFactoryBean.setServiceInterface(SpitterService.class);
        return proxyFactoryBean;
    }
}