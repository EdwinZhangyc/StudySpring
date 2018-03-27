package com.spring.two.chapterSeven.advancede.customDispatcher;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //将DispatcherServlet映射到"/"下
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    //由ContextLoaderListener加载的应用上下文
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    //指定配置类，DispatcherServlet加载应用上下文
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //限制文件大小不超过2MB，整个请求不超过4MB，所有文件需要写到磁盘中
        registration.setMultipartConfig(new MultipartConfigElement("/tmp/uploads", 2000000, 4000000, 0));
    }
}