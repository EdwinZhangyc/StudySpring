package com.spring.one.chapterFour.aspectOrientedProgramming.notifyParameter;

import com.spring.one.chapterTwo.configBean.XMLConfig.BlankDisc;
import com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

/**
 * 程序清单4.7 配置NotifyParameter记录每个磁道的播放次数
 */
@Configuration
@EnableAspectJAutoProxy
public class NotifyParameterConfig {

    @Bean
    public NotifyParameter notifyParameter () {
        return new NotifyParameter();
    }

    @Bean
    public CompactDisc compactDisc() {
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setTitle("title");
        blankDisc.setArtist("artist");
        List<String> stringList = new ArrayList<String>();
        stringList.add("11");
        stringList.add("22");
        stringList.add("33");
        stringList.add("44");
        stringList.add("55");
        blankDisc.setTracks(stringList);
        return blankDisc;
    }
}