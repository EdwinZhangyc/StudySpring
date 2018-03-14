package com.zyc.test.chapterThree.advancedConfiguration.injectOutValue;

import com.zyc.test.chapterTwo.configBean.XMLConfig.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 程序清单3.7 使用@PropertySource和 Environment
 */
@Configuration
@PropertySource("classpath:config/chapterThree/test.properties")
public class ExpressiveConfig {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc disc () {
        BlankDisc blankDisc =  new BlankDisc();
        blankDisc.setArtist(env.getProperty("disc.artist"));
        blankDisc.setTitle(env.getProperty("disc.title"));
        return blankDisc;
    }
}