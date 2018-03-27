package com.spring.two.chapterSeven.advancede.customDispatcher;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 程序清单7.10 使用@ControllerAdvice，为所有的控制器处理异常
 */
//定义控制器类
@ControllerAdvice
public class AppWideExceptionHandler {

    //定义异常处理方法
    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle() {
        return "error/duplicate";
    }
}