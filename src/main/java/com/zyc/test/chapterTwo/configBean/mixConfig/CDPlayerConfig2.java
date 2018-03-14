package com.zyc.test.chapterTwo.configBean.mixConfig;

import com.zyc.test.chapterTwo.configBean.autoWiring.CompactDisc;
import com.zyc.test.chapterTwo.configBean.javaConfigBean.SgtPeppers1;
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