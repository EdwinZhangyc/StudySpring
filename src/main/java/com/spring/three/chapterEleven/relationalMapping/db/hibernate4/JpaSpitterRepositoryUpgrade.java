package com.spring.three.chapterEleven.relationalMapping.db.hibernate4;

import com.spring.three.chapterEleven.relationalMapping.db.SpitterRepository;
import com.spring.three.chapterEleven.relationalMapping.domain.Spitter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * 程序清单11.3 将EntityManager的代理注入到Repository中
 */
@Repository
@Transactional
public class JpaSpitterRepositoryUpgrade implements SpitterRepository{

    //注入EntityManager
    @PersistenceContext
    private EntityManager entityManager;

    //使用EntityManager
    public void addSpitter (Spitter spitter){
        entityManager.persist(spitter);
    }

    public Spitter getSpitterById(long id) {
        return entityManager.find(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter){
        entityManager.merge(spitter);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findOne(long id) {
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @Override
    public List<Spitter> findAll() {
        return null;
    }
}