package com.spring.one.chapterTwo.configBean.javaConfigBean;

import com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc;

public class SgtPeppers1 implements CompactDisc {

    private String title = "title1";
    private String artist = "artist1";

    @Override
    public void play() {
        System.out.println ("Playing " + title + " by " + artist);
    }

    @Override
    public void player(int i) {

    }
}