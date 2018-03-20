package com.spring.two.chapterFive.buildSpringWeb.submitForm;

import com.spring.two.chapterFive.buildSpringWeb.modelDatatoView.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class TestSpittleController {

    /**
     * 程序清单5.16 测试处理表单的控制器方法
     * @throws Exception
     */
    @Test
    public void shouldProcessRegistration() throws Exception {

        SpittleRepository mockRepository = mock(SpittleRepository.class);
        Spitter unsaved = new Spitter("1","24hours", "Jack", "ba");
        Spitter saved = new Spitter("1","24hours", "Jack", "ba", 24L);
        when(mockRepository.save(unsaved)).thenReturn(saved);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "24hours")
                .param("lastName","Jack")
                .param("username", "1")
                .param("password", "ba"))
                .andExpect(redirectedUrl("/spitter/1"));
        //校验保存情况
        verify(mockRepository, atLeastOnce()).save(unsaved);
    }
    @Test
    public void showRegistrationForm() throws Exception {

        SpittleController controller = new SpittleController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spittler/register"))
               .andExpect(view().name("registerForm"));
    }
}