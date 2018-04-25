package com.spring.four.chapterTwenty.JmxManager.service;

import com.spring.two.chapterFive.buildSpringWeb.modelDatatoView.Spittle;
import com.spring.two.chapterFive.buildSpringWeb.submitForm.Spitter;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long id);
    Spitter save(Spitter spitter);

    Spitter findByUserName(String username);
}
