package com.spring.four.chapterNineteen.sendEmail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;

@Configuration
@ComponentScan("com")
//这样下面才可以使用Enviroment
@PropertySource("classpath:config/chapterNineteen/mail.properties")
public class EmailConfig {


    @Bean
    public MailSender mailSender(Environment environment){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("mailserver.host"));
        //默认监听25端口
        mailSender.setPort(Integer.valueOf(environment.getProperty("mailserver.port")));
        //设置username和password
        mailSender.setUsername(environment.getProperty("mailserver.username"));
        mailSender.setPassword(environment.getProperty("mailserver.password"));
        return mailSender;
    }

    @Bean
    public JndiObjectFactoryBean mailSession() {

        JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
        jndi.setJndiName("mail/Session");
        jndi.setProxyInterface(MailSession.class);
        jndi.setResourceRef(true);
        return jndi;
    }

    @Bean
    public MailSender mailSenderToJDNI(MailSession mailSession){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setSession(mailSession);
        return mailSender;
    }
}