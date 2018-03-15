package com.spring.one.chapterFour.aspectOrientedProgramming.writePointcut;

/**
 * 定义切点
 * execution(* Performance.perfrom(..))
 */
public interface Performance {
    void perfrom (String sql);
}