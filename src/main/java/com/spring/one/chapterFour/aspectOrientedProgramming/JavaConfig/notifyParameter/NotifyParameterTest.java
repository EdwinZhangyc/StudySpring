package com.spring.one.chapterFour.aspectOrientedProgramming.JavaConfig.notifyParameter;

import com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
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

        compactDisc.player(2);
        compactDisc.player(2);
        compactDisc.player(2);
        compactDisc.player(1);
        compactDisc.player(1);
        compactDisc.player(2);
        compactDisc.player(2);
        assertEquals(1, notifyParameter.getPlayCount(1));
        assertEquals(1, notifyParameter.getPlayCount(2));
        assertEquals(2, notifyParameter.getPlayCount(1));
        assertEquals(3, notifyParameter.getPlayCount(1));
        assertEquals(5, notifyParameter.getPlayCount(2));
    }

}