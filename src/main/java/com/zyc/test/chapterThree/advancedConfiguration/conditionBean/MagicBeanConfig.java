package com.zyc.test.chapterThree.advancedConfiguration.conditionBean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * 条件化地配置bean
 */
@Configuration
public class MagicBeanConfig {

    @Bean
    @Conditional(MagicCondition.class)
    public MagicBean magicBean () {
        return new MagicBean();
    }
}