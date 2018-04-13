package com.spring.three.chapterTwelve.useNoSQL.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisOperations;

import java.util.List;

public class RedisOperation {

    @Autowired
    private RedisOperations<String, Product> redisTemplate;

    public void test() {

        //使用最简单的值
        Product product = new Product();
        redisTemplate.opsForValue().set(product.getSku(), product);
        Product product1 = redisTemplate.opsForValue().get("123456");

        //使用List的值，在添加一个元素leftPush在头部，rightPush在尾部添加
        redisTemplate.opsForList().leftPush("cart", product);
        redisTemplate.opsForList().rightPush("cart", product);
        //弹出元素
        Product first = redisTemplate.opsForList().leftPop("cart");
        Product end = redisTemplate.opsForList().rightPop("cart");
        //获取区间值[2, 12)
        List<Product> products = redisTemplate.opsForList().range("cart", 2, 12);

        //在Set上执行操作
        redisTemplate.opsForSet().add("cart1", product);
        //获得差异，交集，并集,删除
        //List<Product> diff = redisTemplate.opsForSet().difference("cart1", "cart2");
        //List<Product> union =  redisTemplate.opsForSet().union("cart1", "cart2");
        //List<Product> isect = redisTemplate.opsForSet().isect("cart1", "cart2");
        redisTemplate.opsForSet().remove("cart");

        //绑定到某个key上
        BoundListOperations<String, Product> cart = redisTemplate.boundListOps("cart");
        Product product2 = cart.rightPop();
        cart.rightPush(product);
        cart.rightPush(product1);
        cart.rightPush(product2);


    }
}