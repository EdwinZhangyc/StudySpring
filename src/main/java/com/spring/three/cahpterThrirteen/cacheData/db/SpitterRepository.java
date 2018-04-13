package com.spring.three.cahpterThrirteen.cacheData.db;


import com.spring.three.cahpterThrirteen.cacheData.domain.Spitter;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * Repository interface with operations for {@link Spitter} persistence.
 * @author habuma
 */
public interface SpitterRepository {

  /**
   * 缓存这个方法的结果，实现该方法的类方法都具有这个特性，该特性为，
   * 先查询缓存中是否有spittleCache这个方法，没有的话在执行findOne方法，得到值后存储到缓存中
   */
  @Cacheable("spittleCache")
  Spitter findOne(long id);

  /**
   * 该方法表示所有执行save方法得到的返回值，存储到spittleCache缓存方法中
   * 同时使用SpEL自定义设置key值，默认key值为返回对象名称，该实例就为spitter，
   * 这并不是我们想要的，所以需要自定义key值，得到返回id作为key值
   */
  @CachePut(value = "spittleCache", key = "#result.id")
  Spitter save(Spitter spitter);
  //long count();
  //
  //
  //
  //Spitter findByUsername(String username);
  //
  //List<Spitter> findAll();

}
