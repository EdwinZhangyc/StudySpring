package com.spring.four.chapterTwenty.JmxManager.controller;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;

/**
 * 程序清单20.1 通过注解把HomeController转变为MBean
 */
@Controller
//将SpittleController导出为MBean
@ManagedResource(objectName = "spitter:name=SpittleController")
public class SpittleControllerAnnotation {

    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;
    private int spittlesPerpage = DEFAULT_SPITTLES_PER_PAGE;

    //@ManagedAttribute将spittlesPerpage暴露为托管属性
    @ManagedAttribute
    public int getSpittlesPerpage() {
        return spittlesPerpage;
    }

    @ManagedAttribute
    public void setSpittlesPerpage(int spittlesPerpage) {
        this.spittlesPerpage = spittlesPerpage;
    }
}