package com.spring.four.chapterFifteen.RMIService.config;

import com.spring.four.chapterFifteen.RMIService.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.remoting.caucho.BurlapServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

@Configuration
public class BurlapConfig {

    //发布服务
    @Bean
    public BurlapServiceExporter burlapServiceExporter(SpitterService spitterService){

        BurlapServiceExporter burlapServiceExporter = new BurlapServiceExporter();
        burlapServiceExporter.setService(spitterService);
        burlapServiceExporter.setServiceInterface(SpitterService.class);
        return burlapServiceExporter;
    }

    //请求转接
    @Bean
    public HandlerMapping handlerMapping(){

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties properties = new Properties();
        properties.setProperty("/spitter.service", "burlapServiceExporter");
        mapping.setMappings(properties);
        return mapping;
    }

    //请求服务
    @Bean
    public BurlapProxyFactoryBean burlapProxyFactoryBean(){
        BurlapProxyFactoryBean burlapProxyFactoryBean = new BurlapProxyFactoryBean();
        burlapProxyFactoryBean.setServiceUrl("http://localhost:8080/Spitter/spitter.service");
        burlapProxyFactoryBean.setServiceInterface(SpitterService.class);
        return  burlapProxyFactoryBean;
    }
}