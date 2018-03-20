package com.spring.two.chapterFive.buildSpringWeb.modelDatatoView;

import com.spring.two.chapterFive.buildSpringWeb.submitForm.Spitter;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    SpittleRepository findOne(long id);
    Spitter save(Spitter spitter);

    Spitter findByUserName(String username);
}
