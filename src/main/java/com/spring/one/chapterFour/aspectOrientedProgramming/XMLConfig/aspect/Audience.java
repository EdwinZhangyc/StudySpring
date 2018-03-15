package com.spring.one.chapterFour.aspectOrientedProgramming.XMLConfig.aspect;

/**
 * 程序清单4.1 Audience类：观看演出的切面
 */

public class Audience {

    //表演之前
    public void silenceCellPhones() {
        System.out.println("silenceCellPhones");
    }

    //表演之前
    public void takeSeats() {
        System.out.println("takeSeats");
    }

    //表演之后返回时触发
    public void applause(){
        System.out.println("applause");
    }

    //表演失败触发
    public void demandRefund () {
        System.out.println("demandRefund");
    }
}