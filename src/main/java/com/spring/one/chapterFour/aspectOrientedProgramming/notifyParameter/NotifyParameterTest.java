package com.spring.one.chapterFour.aspectOrientedProgramming.notifyParameter;

import com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NotifyParameterConfig.class)
public class NotifyParameterTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private NotifyParameter notifyParameter;
    @Autowired
    private CompactDisc compactDisc;

    @Test
    public void testNotifyParameter () {

        compactDisc.play();
        //assertEqulas(1, notifyParameter.getPlayCount(1));
    }

}