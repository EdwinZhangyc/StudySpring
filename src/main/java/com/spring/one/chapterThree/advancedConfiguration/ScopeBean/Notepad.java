package com.spring.one.chapterThree.advancedConfiguration.ScopeBean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 切换bean的作用域，到prototype
 */
@Component
//使用Scope注解进行切换作用域
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope("prototype") = @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE
public class Notepad {
}