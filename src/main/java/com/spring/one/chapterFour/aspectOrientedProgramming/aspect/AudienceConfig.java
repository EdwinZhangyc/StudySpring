package com.spring.one.chapterFour.aspectOrientedProgramming.aspect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 程序清单4.3 在JavaConfig中启动AspectJ注解的自动代理
 */
@Configuration
@EnableAspectJAutoProxy//启动AspectJ自动代理
@ComponentScan
public class AudienceConfig {

    //声明Audience bean
    @Bean
    public AudienceUpgrade audienceUpgrade() {
        return new AudienceUpgrade();
    }
}