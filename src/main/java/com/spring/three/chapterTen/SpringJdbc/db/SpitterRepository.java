package com.spring.three.chapterTen.SpringJdbc.db;


import com.spring.three.chapterTen.SpringJdbc.domain.Spitter;

import java.util.List;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository {

  long count();
  
  Spitter save(Spitter spitter);
  
  Spitter findOne(long id);

  Spitter findOneSpittle(long id);

  Spitter findByUsername(String username);

  List<Spitter> findAll();

  void addSpitter(Spitter spitter);

}
