package com.zyc.test.chapterTwo.configBean.javaConfigBean;

import com.zyc.test.chapterTwo.configBean.autoWiring.CompactDisc;

public class SgtPeppers1 implements CompactDisc {

    private String title = "title1";
    private String artist = "artist1";

    @Override
    public void play() {
        System.out.println ("Playing " + title + " by " + artist);
    }
}