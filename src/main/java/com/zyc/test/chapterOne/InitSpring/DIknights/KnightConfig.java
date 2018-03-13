package com.zyc.test.chapterOne.InitSpring.DIknights;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用这种JavaConfig的方式来描述配置
 */
@Configuration //该注解表示该类是配置类
public class KnightConfig {

    @Bean
    public Knight knight () {

        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest () {

        return new SlayDragonQuest(System.out);
    }
}