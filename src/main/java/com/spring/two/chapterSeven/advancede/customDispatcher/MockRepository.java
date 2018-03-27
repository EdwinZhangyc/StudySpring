package com.spring.two.chapterSeven.advancede.customDispatcher;

import org.springframework.stereotype.Component;

import java.util.List;

@Component("spittleRepository")
public class MockRepository implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long id) {
        return null;
    }

    @Override
    public void save(Spittle spitter) {

    }

    @Override
    public Spitter findByUserName(String username) {
        return null;
    }
}