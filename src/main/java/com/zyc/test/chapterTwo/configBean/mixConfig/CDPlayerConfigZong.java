package com.zyc.test.chapterTwo.configBean.mixConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * JavaConfig
 */
@Configuration
//可以使用一个总配置类引入其他所有配置类
@Import({CDPlayerConfig1.class, CDPlayerConfig2.class, CDPlayerConfig3.class})
//
@ImportResource("classpath:context/chapterTwo/BlankDiscConfig.xml")
public class CDPlayerConfigZong {


}