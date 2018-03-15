package com.spring.one.chapterFour.aspectOrientedProgramming.XMLConfig.Around;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 程序清单4.5 使用环绕通知重新实现AudienceUpgrade切面
 * 环绕通知相当于同时定义了方法的前置通知与后置通知
 */
public class AduienceUpgradeAround {

    //定义命名的切点
    public void performance () {}

    //环绕通知方法
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