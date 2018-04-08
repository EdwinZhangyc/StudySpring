package com.spring.three.chapterEleven.relationalMapping.db.hibernate4;

import com.spring.three.chapterEleven.relationalMapping.db.SpitterRepository;
import com.spring.three.chapterEleven.relationalMapping.domain.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Repository
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Inject
    //注入SessionFactory
    public HibernateSpitterRepository (SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //从SessionFactory中取出Session
    public Session currentSession() {

        return sessionFactory.getCurrentSession();
    }
    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {

        //使用当前Session
        Serializable id = currentSession().save(spitter);
        return new Spitter((Long)id,
                    spitter.getUsername(),
                    spitter.getPassword(),
                    spitter.getFullName(),
                    spitter.getEmail(),
                    spitter.isUpdateByEmail());
    }

    @Override
    public Spitter findOne(long id) {
        return (Spitter)currentSession().get(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession()
                .createCriteria(Spitter.class)
                .add(Restrictions.eq("username", username))
                .list().get(0);
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>)currentSession()
                .createCriteria(Spitter.class).list();
    }
}