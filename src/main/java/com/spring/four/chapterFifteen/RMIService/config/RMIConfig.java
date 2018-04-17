package com.spring.four.chapterFifteen.RMIService.config;

import com.spring.four.chapterFifteen.RMIService.SpitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class RMIConfig {

    /**
     * 使用RmiServiceExporter将SpitterServiceImpl发布为RMI服务的最简单方式，是添加如下bean
     * 发布服务
     * @return
     */
    @Bean
    public RmiServiceExporter rmiServiceExporter(SpitterService spitterService){

        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(spitterService);
        rmiServiceExporter.setServiceName("spitterService");
        rmiServiceExporter.setServiceInterface(SpitterService.class);
        //尝试绑定mri.spitter.com主机1199端口上的RMI注册表
        rmiServiceExporter.setRegistryHost("rmi.spitter.com");
        rmiServiceExporter.setRegistryPort(1199);
        return rmiServiceExporter;
    }

    /**
     * 调用服务
     */
    @Bean
    public RmiProxyFactoryBean spitterService(){
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost/SpitterService");
        rmiProxyFactoryBean.setServiceInterface(SpitterService.class);
        return rmiProxyFactoryBean;
    }
}