package com.zyc.test.chapterOne.InitSpring.DIknights;

/**
 * 依赖注入之一constructor injection
 */
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {//quest被注入进来
        this.quest = quest;
    }

    public void embarkOnQuest () {
        quest.embark ();
    }
}