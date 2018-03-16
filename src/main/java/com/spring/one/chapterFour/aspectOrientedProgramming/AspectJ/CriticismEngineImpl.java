package com.spring.one.chapterFour.aspectOrientedProgramming.AspectJ;

public class CriticismEngineImpl implements CriticismEngine {
    @Override
    public String getCriticism() {

        int i = (int)(Math.random() * criticismPool.length);
        return criticismPool[i];

    }
    //injected
    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
