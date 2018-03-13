package com.zyc.test.chapterTwo.configBean.autoWiring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
/**
 * 程序清单2.5 测试组件扫描能够发现CompactDisc
 */
//在测试开始时自动创建Spring应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//指定配置类
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    //@Rule
    //public final StandardOutputStreamLog log = new StandardOutputStreamLog ();

    @Autowired
    private CompactDisc CD;

    @Test
    public void cdShouldNotBeNull () {
        //使用该方式验证CD是否被注入进来，成功则注入进来了
        assertNotNull(CD);
    }

    //@Test
    //public void paly () {
    //    CD.play();
    //    assertEquals("Playing title by artist", log.getLog());
    //}
}