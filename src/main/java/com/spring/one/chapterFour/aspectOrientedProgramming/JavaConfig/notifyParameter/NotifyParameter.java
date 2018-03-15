package com.spring.one.chapterFour.aspectOrientedProgramming.JavaConfig.notifyParameter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * 程序清单4.6 使用参数化的通知来记录磁道播放的次数
 */
@Aspect
public class NotifyParameter {

    private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();

    @Pointcut("execution(* com.spring.one.chapterTwo.configBean.autoWiring.CompactDisc.player(int)) && args(trackNumber)")
    public void trackPlayed (int trackNumber){}

    //在播放前为该磁道计数
    @Before("trackPlayed(trackNumber)")
    public void countTrack (int trackNumber) {
        int currentCount = getPlayCount(trackNumber);
        trackCounts.put(trackNumber, currentCount + 1);
    }

    public int getPlayCount(int trackNumber) {
        //containsKey 如果此映射包含指定键的映射，则返回 true 。
        return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
    }

}