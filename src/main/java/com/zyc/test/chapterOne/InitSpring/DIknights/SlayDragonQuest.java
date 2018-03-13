package com.zyc.test.chapterOne.InitSpring.DIknights;

import java.io.PrintStream;

/**
 * 将Quest注入到Knight中，使用javaConfig或是XML配置方式进行DI依赖注入
 */
public class SlayDragonQuest implements Quest {

    private PrintStream printStream;//该类是System.out的父类更加通用

    public SlayDragonQuest (PrintStream printStream) {//在构造方法中初始化printStream
        this.printStream = printStream;
    }

    @Override
    public void embark() {
        printStream.println ("勇士杀死一条龙");
    }
}