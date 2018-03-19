package com.spring.two.chapterFive.buildSpringWeb.buildSpringMVC;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * 程序清单5.6 改进HomeControllerTest
 */
public class HomeControllerNewTest {

    @Test
    public void testHomePage() throws Exception {

        HomeController homeController = new HomeController();
        //搭建MockMvc
        MockMvc mockMvc = standaloneSetup(homeController).build();
        //对“/”执行get请求
        mockMvc.perform(get("/"))
                //预期得到home视图
                .andExpect(view().name("home"));
    }
}