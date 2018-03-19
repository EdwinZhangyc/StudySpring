package com.spring.two.chapterFive.buildSpringWeb.buildSpringMVC;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 程序清单5.1 配置DisptcherServlet，该java类类似于web.xml的作用
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

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

}