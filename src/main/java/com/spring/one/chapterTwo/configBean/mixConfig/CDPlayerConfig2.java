package com.spring.one.chapterTwo.configBean.mixConfig;

import com.spring.one.chapterTwo.configBean.javaConfigBean.SgtPeppers1;
import com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * JavaConfig
 */
@Configuration
public class CDPlayerConfig2 {

    @Bean(name = "sgtPeppers__")
    public CompactDisc sgtPeppers1 () {
        return new SgtPeppers1();
    }

}