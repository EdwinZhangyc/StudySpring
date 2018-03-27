package com.spring.two.chapterSeven.advancede.customDispatcher;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.spring.two.chapterSeven.advancede.customDispatcher")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/viewsChapterSeven/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(
                org.springframework.web.servlet.view.JstlView.class
        );
        return resolver;
    }

    //使用Servlet3.0解析multipart请求
    @Bean
    public MultipartResolver multipartResolver() throws Exception {
        return new StandardServletMultipartResolver();
    }

    //使用Jakarta Commons FilrUpload multipart 解析器
    @Bean
    public MultipartResolver commonesMultipartResolver() throws Exception {

        //通过设置uploadTempDir属性，指定上传文件的位置，默认是servlet容器的临时目录
        //同时可以限制multipart上传文件大小，与MultiprtConfigElement不同，不可以设置multipart整体的最大容量
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/uploads"));
        multipartResolver.setMaxInMemorySize(0);//最大内存设置为0字节
        multipartResolver.setMaxUploadSize(2000000);
        return multipartResolver;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}