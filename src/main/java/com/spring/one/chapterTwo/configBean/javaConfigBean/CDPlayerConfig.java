package com.spring.one.chapterTwo.configBean.javaConfigBean;

import com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc;
import com.spring.one.chapterTwo.configBean.autoWiring.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * JavaConfig
 */
@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers () {
        return new SgtPeppers();
    }

    @Bean(name = "sgtPeppers__")
    public CompactDisc sgtPeppers1 () {
        return new SgtPeppers1();
    }

    @Bean(name="cdplayImpl")
    //使用参数的方式将CompactDisc类型的bean注入  ,可以使用构造函数，setter，或是其他赋值方法injection
    // 参数的别名当只有一个同类型的bean时可以随便写，多个的时候需要与注入的bean的别名一致
    public CDPlayer cdPlayer (CompactDisc sgtPeppers__) {
        CDPlayer cdPlayer =  new CDPlayer();
        cdPlayer.tt(sgtPeppers__);
        return cdPlayer;
    }
}