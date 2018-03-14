package com.zyc.test.chapterTwo.configBean.mixConfig;

import com.zyc.test.chapterTwo.configBean.autoWiring.CompactDisc;
import com.zyc.test.chapterTwo.configBean.autoWiring.SgtPeppers;
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