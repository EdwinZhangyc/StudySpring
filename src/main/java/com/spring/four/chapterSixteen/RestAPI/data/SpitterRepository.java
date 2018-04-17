package com.spring.four.chapterSixteen.RestAPI.data;


import com.spring.four.chapterSixteen.RestAPI.domain.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
