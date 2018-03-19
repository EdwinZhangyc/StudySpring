package com.spring.two.chapterFive.buildSpringWeb.modelDatatoView;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    SpittleRepository findOne(long id);
}
