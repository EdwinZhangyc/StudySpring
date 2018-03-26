package com.spring.two.chapterFive.buildSpringWeb.buildSpringMVC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 程序清单5.2 最小但可用的Spring MVC配置
 */
@Configuration
//启动SpringMVC
@EnableWebMvc
//开启自动扫描组件
@ComponentScan("com.spring.two.chapterFive.buildSpringWeb.buildSpringMVC")
public class WebConfig extends WebMvcConfigurerAdapter {

    //配置JSP视图解析器
    @Bean
    public ViewResolver viewResolver () {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        //resolver.setExposeContextBeansAsAttributes(true);
        resolver.setViewClass(
                org.springframework.web.servlet.view.JstlView.class
        );
        return resolver;
    }

    //配置静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}