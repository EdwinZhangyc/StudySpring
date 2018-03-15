package com.spring.one.chapterTwo.configBean.mixConfig;

import com.spring.one.chapterTwo.configBean.autoWiring.SgtPeppers;
import com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * JavaConfig
 */
@Configuration
public class CDPlayerConfig1 {

    @Bean
    public CompactDisc sgtPeppers () {
        return new SgtPeppers();
    }

}