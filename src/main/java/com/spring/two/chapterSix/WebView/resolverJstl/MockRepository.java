package com.spring.two.chapterSix.WebView.resolverJstl;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockRepository implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public SpittleRepository findOne(long id) {
        return null;
    }

    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findByUserName(String username) {
        return null;
    }
}