package com.spring.one.chapterTwo.configBean.autoWiring;

import org.springframework.stereotype.Component;

/**
 * 定义一个CD的实现类，使用@Component注解表示一个Bean 等待Spring初始化
 * 程序清单2.2 带有@Component注解的CompactDisc实现类SgtPeppers
 */
//@Component("aaa")//设置别名默认类名首字母小写  等同于@Named("aaa")
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "title";
    private String artist = "artist";

    @Override
    public void play() {
        System.out.println ("Playing " + title + " by " + artist);
    }

    @Override
    public void player(int i) {

    }
}