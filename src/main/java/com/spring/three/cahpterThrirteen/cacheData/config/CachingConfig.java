package com.spring.three.cahpterThrirteen.cacheData.config;

//import net.sf.ehcache.CacheManager;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * 程序清单13.1 通过使用@EnableCaching启动注解驱动的缓存
 */
@Configuration
@EnableCaching//启动缓存
public class CachingConfig {

    /**
     * 声明缓存管理器
     */
    /*@Bean
    public CacheManager cacheManager(){
        //ConcurrentMapCacheManager适用于开发，测试环境，基础应用，很方便
        return new ConcurrentMapCacheManager();
    }*/

    /**
     * 使用EhCache缓存
     * 程序清单13.3 以java配置的方式设置EhCacheCacheManager
     */
    //EhCacheCacheManagerFactoryBean
    //@Bean
    //public EhCacheManagerFactoryBean ehchache(){
    //    EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
    //    ehCacheManagerFactoryBean.setConfigLocation(
    //            new ClassPathResource("context/chapterThirteen/ehcache.xml")
    //    );
    //    return ehCacheManagerFactoryBean;
    //}
    ////配置EhCacheCacheManger
    //@Bean
    //public EhCacheCacheManager ehCacheCacheManager(CacheManager cm){
    //    return new EhCacheCacheManager(cm);
    //}

    /**
     * 使用redis缓存
     * 程序清单13.4 配置将缓存条目存储在Redis服务器的缓存服务器
     */
    /*//Redis连接工厂bean
    @Bean
    public JedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
    //redis Template Bean
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    redis cache manager
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }
*/
    /**
     * 使用多个缓存管理器
     * 程序清单13.5 CompositeCacheManager会迭代一个缓存管理器的列表
     */
    @Bean
    public EhCacheManagerFactoryBean ehchache(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(
                new ClassPathResource("context/chapterThirteen/ehcache.xml")
        );
        return ehCacheManagerFactoryBean;
    }
    @Bean
    public JedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }
    //redis Template Bean
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
    @Bean
    public CacheManager cacheManager(
            net.sf.ehcache.CacheManager cm,
            javax.cache.CacheManager jcm){
        //创建CompositeCacheManager
        CompositeCacheManager compositeCacheManager = new CompositeCacheManager();
        List<CacheManager> managers = new ArrayList<CacheManager>();
        managers.add(new JCacheCacheManager(jcm));
        managers.add(new EhCacheCacheManager(cm));
        managers.add(new RedisCacheManager(redisTemplate(redisConnectionFactory())));
        managers.add(new ConcurrentMapCacheManager());
        //添加单个缓存管理器
        compositeCacheManager.setCacheManagers(managers);
        return compositeCacheManager;
    }
}