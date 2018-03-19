package com.spring.two.chapterFive.buildSpringWeb.buildSpringMVC;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * 程序清单5.5 HomeControllerTest：测试HomeController
 */
public class HomeControllerTest {
    @Test
    public void testHomePage() throws Exception {

        HomeController homeController = new HomeController();
        assertEquals("home", homeController.home());
    }
}