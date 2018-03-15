package com.spring.one.chapterTwo.configBean.javaConfigBean;

import com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc;

public class CDPlayer {

    private CompactDisc cd;


    public void play () {
        cd.play();
    }

    public void tt(CompactDisc sgtPeppers__) {
        this.cd = sgtPeppers__;
    }
}