package com.spring.four.chapterTwenty.JmxManager.service;

/**
 * 作为指定接口使用，接口中方法名称要与所要开放暴露的方法保持一致
 */
public interface SpittleControllerManagedOperations {

    int getSpittlesPerPage();
    void setSpittlePerPage();
}