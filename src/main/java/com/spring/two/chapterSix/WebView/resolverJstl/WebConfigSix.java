package com.spring.two.chapterSix.WebView.resolverJstl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.two.chapterSix.WebView.resolverJstl")
public class WebConfigSix extends WebMvcConfigurerAdapter {

    //第一版使用JSTL进行解析页面
    //@Bean
    //public ViewResolver viewResolver() {
    //
    //    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    //    resolver.setPrefix("/WEB-INF/viewsChapterSix/");
    //    resolver.setSuffix(".jsp");
    //    resolver.setViewClass(
    //            org.springframework.web.servlet.view.JstlView.class
    //    );
    //    return resolver;
    //}

    //第二版，使用Tiles进行页面布局
    /**
     * 程序清单6.1 配置TileConfigurer来解析定义
     */
    @Bean
    public TilesConfigurer tilesConfigurer () {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{
                //定义Tile的位置,加载WEB-INF文件夹下所有额度tiles.xml
                //"/WEB-INF/**/tiles.xml"
                "/WEB-INF/layout/tiles.xml",
                "/WEB-INF/viewsChapterSix/**/tiles.xml"
        });
        //启动刷新功能
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }
    //使用Tiles进行布局
    @Bean
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
    }

    /**
     * 第三版使用Thymeleaf
     * 1、ThymeleafViewResolver:将逻辑视图名称解析为Thymeleaf模板视图
     * 2、SpringTemplateEngine:处理模板并渲染结果
     * 3、TemplateResolver:加载Thymeleaf的支持
     */
    ////Thymeleaf视图解析器
    //@Bean
    //public ViewResolver viewResolver(SpringTemplateEngine) {
    //
    //}




    //在根路径下进行查找
    //@Bean
    //public MessageSource messageSource() {
    //
    //    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    //    messageSource.setBasename("messages");
    //    return messageSource;
    //}
    //很据路径查找
    //@Bean
    //public MessageSource messageSource2() {
    //
    //    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    //    messageSource.setBasename("file:///etc/messages");
    //    messageSource.setCacheSeconds(10);
    //    return messageSource;
    //}

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}