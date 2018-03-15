package com.spring.one.chapterFour.aspectOrientedProgramming.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 程序清单4.1 Audience类：观看演出的切面
 */
@Aspect
public class Audience {

    //表演之前
    @Before("execution(* com.spring.one.chapterFour.aspectOrientedProgramming.writePointcut.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("silenceCellPhones");
    }

    //表演之前
    @Before("execution(* com.spring.one.chapterFour.aspectOrientedProgramming.writePointcut.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("takeSeats");
    }

    //表演之后返回时触发
    @AfterReturning("execution(* com.spring.one.chapterFour.aspectOrientedProgramming.writePointcut.Performance.perform(..))")
    public void applause(){
        System.out.println("applause");
    }

    //表演失败触发
    @AfterThrowing("execution(* com.spring.one.chapterFour.aspectOrientedProgramming.writePointcut.Performance.perform(..))")
    public void demandRefund () {
        System.out.println("demandRefund");
    }
}