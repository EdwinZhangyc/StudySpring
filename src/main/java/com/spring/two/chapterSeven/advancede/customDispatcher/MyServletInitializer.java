package com.spring.two.chapterSeven.advancede.customDispatcher;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 程序清单7.1 通过实现WebApplicationInitializer来注册servlet
 * 程序清单7.2 注册Filter的WebApplicationInitializer
 */
public class MyServletInitializer implements WebApplicationInitializer{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        ServletRegistration.Dynamic myservlet =
                //注册servlet
                servletContext.addServlet("myservlet",MyServlet.class);
        //映射servlet
        myservlet.addMapping("/custom/**");

        javax.servlet.FilterRegistration.Dynamic filter =
                //注册filter
                servletContext.addFilter("myfilter", MyFilter.class);
        //添加fileter的映射路径
        filter.addMappingForUrlPatterns(null, false, "/custom/*");
    }
}