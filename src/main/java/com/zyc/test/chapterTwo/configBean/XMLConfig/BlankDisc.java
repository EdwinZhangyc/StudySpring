package com.zyc.test.chapterTwo.configBean.XMLConfig;

import com.zyc.test.chapterTwo.configBean.autoWiring.CompactDisc;

import java.util.List;

/**
 * 使用XML配置进行字面量值注入到属性中，详情见BlankDiscConfig.xml
 */
public class BlankDisc implements CompactDisc {

    private String title;
    private String artist;
    private List<String> tracks;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println ("Playing " + title + " by " + artist);
        for (String track:
             tracks) {
            System.out.println("-track" + "track");
        }
    }
}