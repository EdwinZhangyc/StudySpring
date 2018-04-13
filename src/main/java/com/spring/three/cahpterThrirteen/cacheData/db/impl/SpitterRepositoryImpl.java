package com.spring.three.cahpterThrirteen.cacheData.db.impl;

import com.spring.three.cahpterThrirteen.cacheData.db.SpitterRepository;
import com.spring.three.cahpterThrirteen.cacheData.domain.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class SpitterRepositoryImpl implements SpitterRepository {

    private static final String SELECT_SPITTER_BY_ID = "";

    @Autowired
    private JdbcOperations jdbcOperations;


    /**
     * 程序清单13.6 通过使用@Cacheable，在缓存中存储和获取值
     * @param id
     * @return
     */
    //@Cacheable("spittleCache")//缓存这个方法的结果
    public Spitter findOne(long id) {
        try{
            return jdbcOperations.queryForObject(
                    SELECT_SPITTER_BY_ID,
                    (rs, rowNum) -> {
                        return new Spitter(
                                rs.getLong("id"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("fullname"),
                                rs.getString("email"),
                                rs.getBoolean("updateByEmail"));
                    }, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public void remove(long spitterId) {

    }
}