package com.spring.one.chapterFour.aspectOrientedProgramming.JavaConfig.aspect;

import org.aspectj.lang.annotation.*;

/**
 * 对Audience切面进行upgrade 由于每次都要重复声明切点表达式
 */
@Aspect
public class AudienceUpgrade {

    //定义切点表达式
    @Pointcut("execution(* com.spring.one.chapterFour.aspectOrientedProgramming.Performance.perfrom(..))")
    public void performance(){}

    //表演之前
    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("silenceCellPhones");
    }

    //表演之前
    @Before("performance()")
    public void takeSeats() {
        System.out.println("takeSeats");
    }

    //表演之后返回时触发
    @AfterReturning("performance()")
    public void applause(){
        System.out.println("applause");
    }

    //表演失败触发
    @AfterThrowing("performance()")
    public void demandRefund () {
        System.out.println("demandRefund");
    }
}