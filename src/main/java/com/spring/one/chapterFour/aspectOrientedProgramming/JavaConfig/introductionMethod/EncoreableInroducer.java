package com.spring.one.chapterFour.aspectOrientedProgramming.JavaConfig.introductionMethod;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableInroducer {

    @DeclareParents(value = "com.spring.one.chapterFour.aspectOrientedProgramming.Performance+",
                    defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;

}