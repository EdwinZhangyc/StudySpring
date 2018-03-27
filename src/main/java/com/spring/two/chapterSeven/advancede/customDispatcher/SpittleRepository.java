package com.spring.two.chapterSeven.advancede.customDispatcher;


import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    Spittle findOne(long id);
    void  save(Spittle spittle);

    Spitter findByUserName(String username);
}
