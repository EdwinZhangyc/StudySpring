package com.spring.three.chapterTwelve.useNoSQL.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    /**
     * 配置redisConnectionFactory
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory cf = new JedisConnectionFactory();
        cf.setPort(7379);//默认为6379，当有修改则进行指定
        cf.setHostName("redis-server");//当连接其他主机时进行设置
        //设置凭证
        cf.setPassword("asdasd");
        return cf;
    }
    /**
     * 当经常使用RedisTemplate或StringRedisTemplate，可以考虑将其设置为bean
     */
    @Bean
    public RedisTemplate<String, Product> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Product> redisTemplate = new RedisTemplate<String, Product>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //我们希望将Product类型的value序列化为JSON，而Key是String类型
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Product>(Product.class));
        return redisTemplate;
    }
    //以下是声明StringRedisTemplate模板
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        return new StringRedisTemplate(redisConnectionFactory);
    }
}