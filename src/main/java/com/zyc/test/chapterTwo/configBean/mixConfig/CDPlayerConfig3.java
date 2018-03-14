package com.zyc.test.chapterTwo.configBean.mixConfig;

import com.zyc.test.chapterTwo.configBean.autoWiring.CompactDisc;
import com.zyc.test.chapterTwo.configBean.javaConfigBean.CDPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * JavaConfig
 */
@Configuration
@Import(CDPlayerConfig2.class)//引入其他配置项
public class CDPlayerConfig3 {

    @Bean(name="cdplayImpl")
    //使用参数的方式将CompactDisc类型的bean注入  ,可以使用构造函数，setter，或是其他赋值方法injection
    // 参数的别名当只有一个同类型的bean时可以随便写，多个的时候需要与注入的bean的别名一致
    public CDPlayer cdPlayer (CompactDisc sgtPeppers__) {
        CDPlayer cdPlayer =  new CDPlayer();
        cdPlayer.tt(sgtPeppers__);
        return cdPlayer;
    }
}