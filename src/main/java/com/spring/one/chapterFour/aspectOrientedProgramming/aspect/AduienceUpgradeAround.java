package com.spring.one.chapterFour.aspectOrientedProgramming.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 程序清单4.5 使用环绕通知重新实现AudienceUpgrade切面
 * 环绕通知相当于同时定义了方法的前置通知与后置通知
 */
@Aspect
public class AduienceUpgradeAround {

    //定义命名的切点
    @Pointcut("execution(* com.spring.one.chapterFour.aspectOrientedProgramming.writePointcut.Performance.perform(..))")
    public void performance () {}

    //环绕通知方法
    @Around("performance()")
    public void watchPerformance (ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("silenceCellPhones");
            System.out.println("takeSeats");
            joinPoint.proceed();
            System.out.println("applause");
        } catch (Throwable e) {
            System.out.println("demandRefund");
        }
    }
}