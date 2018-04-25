package com.spring.four.chapterTwenty.JmxManager.config;

import com.spring.four.chapterTwenty.JmxManager.service.PagingNotificationListener;
import com.spring.four.chapterTwenty.JmxManager.service.SpittleControllerManagedOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.access.MBeanProxyFactoryBean;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;

import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("com")
public class JmxRemoteConfig {

    /**
     * 20.2.1 暴露远程MBean
     * ConnectorServerFactoryBean会自动创建JSR-160 JMXConnectorServer默认情况下：
     * 服务器使用JMXMP协议并监听端口9875 因此他将默认绑定：
     * service:jmx:jmxmp://localhost:9875
     */
    @Bean
    public ConnectorServerFactoryBean connectorServerFactoryBean(){
        ConnectorServerFactoryBean serverFactoryBean = new ConnectorServerFactoryBean();
        //为MBean绑定不同的远程访问协议，使用RMI远程调用
        serverFactoryBean.setServiceUrl(
                "service:jmx:rmi://localhost/jndi/rmi://localhost:1099/spitter"
        );
        return new ConnectorServerFactoryBean();
    }
    @Bean
    public RmiRegistryFactoryBean rmiRegistryFactoryBean(){
        RmiRegistryFactoryBean rmiRegistryFactoryBean = new RmiRegistryFactoryBean();
        rmiRegistryFactoryBean.setPort(1099);
        return rmiRegistryFactoryBean;
    }

    /**
     * 20.2.2 访问远程MBean
     */
    @Bean
    public MBeanServerConnectionFactoryBean connectionFactoryBean() throws MalformedURLException {
        MBeanServerConnectionFactoryBean connectionFactoryBean = new MBeanServerConnectionFactoryBean();
        connectionFactoryBean.setServiceUrl("");
        connectionFactoryBean.setServiceUrl(
                "service:jmx:rmi://localhost/jndi/rmi://localhost:1099/spitter"
        );
        return connectionFactoryBean;
    }
    //@Bean
    //public JmxClient jmxClient(MBeanServerConnection connectionFactoryBean){
    //    JmxClient jmxClient = new JmxClient();
    //    jmxClient.setMBeanServerConnection(connectionFactoryBean);
    //    return jmxClient;
    //}

    /**
     * 20.2.3 代理MBean
     */
    @Bean
    public MBeanProxyFactoryBean proxyFactoryBean (MBeanServerConnection connectionFactoryBean) throws MalformedObjectNameException {

        MBeanProxyFactoryBean proxyFactoryBean = new MBeanProxyFactoryBean();
        proxyFactoryBean.setObjectName("");//指定远程MBean名称
        proxyFactoryBean.setServer(connectionFactoryBean);
        proxyFactoryBean.setProxyInterface(SpittleControllerManagedOperations.class);
        return proxyFactoryBean;
    }

    /**
     * 20.3.1 监听通知
     */
    @Bean
    public MBeanExporter mBeanExporter(){
        MBeanExporter mBeanExporter = new MBeanExporter();
        Map<String, PagingNotificationListener> mappings = new HashMap<>();
        mappings.put("Spitter:name=PagingNotificationListener",
                new PagingNotificationListener());
        mBeanExporter.setNotificationListenerMappings(mappings);
        return mBeanExporter;
    }

}