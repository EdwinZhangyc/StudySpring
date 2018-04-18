package com.spring.four.chapterSixteen.RestAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * 程序清单16.2 配置ContentNegotiationManager
 */
@Configuration
@EnableWebMvc
@Component("com")
public class WebConfig extends WebMvcConfigurerAdapter {

    //使用ContentNegotiatingViewResolver作为特殊解析器
    //@Bean
    //public ViewResolver viewResolver(){
    //    return new ContentNegotiatingViewResolver();
    //}


    @Bean
    public ViewResolver viewResolver(ContentNegotiationManager contentNegotiationManager){

        ContentNegotiatingViewResolver cner = new ContentNegotiatingViewResolver();
        cner.setContentNegotiationManager(contentNegotiationManager);
        return cner;
    }

    //通过重载方法创建ContentNegotiatingManager的实现同时可以配置xml进行获取

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        //configurer.defaultContentType(MediaType.APPLICATION_JSON);
        //默认为HTML
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }

    @Bean
    public ViewResolver beanNameViewResolver(){//以bean的形式查找视图
        return new BeanNameViewResolver();
    }

    @Bean
    public View spittles(){
        //将spittles定义为JSON视图
        return new MappingJackson2JsonView();
    }
}