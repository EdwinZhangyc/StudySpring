package com.spring.three.chapterEleven.relationalMapping.db.hibernate4;

import com.spring.three.chapterEleven.relationalMapping.db.SpitterRepository;
import com.spring.three.chapterEleven.relationalMapping.domain.Spitter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * 程序清单11.2 不是用Spring模板的纯JPA Repository
 */
@Repository
@Transactional//表名这个Repository中的持久化方法是在事物上下文中执行的
public class JpaSpitterRepository implements SpitterRepository {

    //注入EntityManagerFactory
    @PersistenceUnit
    private EntityManagerFactory emf;

    //创建并使用EntityManager
    public void addSpitter(Spitter spitter){
        emf.createEntityManager().persist(spitter);
    }

    public Spitter getSpitterById(long id) {
        return emf.createEntityManager().find(Spitter.class, id);
    }

    public void saveSpitter(Spitter spitter){
        emf.createEntityManager().merge(spitter);
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