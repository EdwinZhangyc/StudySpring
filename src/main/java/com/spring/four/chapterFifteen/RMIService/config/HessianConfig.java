package com.spring.four.chapterFifteen.RMIService.config;

import com.spring.four.chapterFifteen.RMIService.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.caucho.SimpleHessianServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import javax.persistence.PrePersist;
import java.util.Properties;

@Configuration
public class HessianConfig {

    //发布服务
    @Bean
    public HessianServiceExporter hessianServiceExporter(SpitterService spitterService){
        HessianServiceExporter hessianServiceExporter = new HessianServiceExporter();
        hessianServiceExporter.setService(spitterService);
        hessianServiceExporter.setServiceInterface(SpitterService.class);
        return hessianServiceExporter;
    }

    //请求转接
    @Bean
    public HandlerMapping handlerMapping(){

        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        Properties properties = new Properties();
        properties.setProperty("/spitter.service", "hessianServiceExporter");
        mapping.setMappings(properties);
        return mapping;
    }

    //请求服务
    @Bean
    public HessianProxyFactoryBean hessianProxyFactoryBean(){
        HessianProxyFactoryBean hessianProxyFactoryBean = new HessianProxyFactoryBean();
        hessianProxyFactoryBean.setServiceUrl("http://localhost:8080/Spitter/spitter.service");
        hessianProxyFactoryBean.setServiceInterface(SpitterService.class);
        return hessianProxyFactoryBean;
    }
}