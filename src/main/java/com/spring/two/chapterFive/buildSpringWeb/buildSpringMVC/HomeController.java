package com.spring.two.chapterFive.buildSpringWeb.buildSpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 程序清单5.3 HomeController：超级简单的控制器
 */
//声明为一个控制器
@Controller
public class HomeController {

    //处理对"/"的GET请求
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home () {
        //视图名为home
        return "home";
    }
}