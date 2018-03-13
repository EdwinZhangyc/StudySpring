package com.zyc.test.chapterOne.InitSpring.AOP;

import java.io.PrintStream;

/**
 * 每个骑士在出行前后，吟游诗人都会为其歌唱
 * 模仿日志模块，安全模块，事物管理  每个类都应该只关心自身的业务逻辑
 * 将吟游诗人定义为一个切面，利用AOP可以声明吟游诗人必须歌颂骑士的探险事迹，而骑士本身并不用直接访问Minstrel
 */
public class Minstrel {

    private PrintStream printStream;

    public Minstrel (PrintStream printStream) {
        this.printStream = printStream;
    }

    public void singBeforeQuest () {
        printStream.println("出发前，歌唱");
    }

    public void singAfterQuest () {
        printStream.println("出发之后，歌唱");
    }
}