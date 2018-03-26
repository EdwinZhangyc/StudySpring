package com.spring.two.chapterFive.buildSpringWeb.modelDatatoView;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class TestSpittr {

    /**
     * 程序清单5.12 测试对某个Spittle的请求，其中ID要在路径变量中指定
     * @throws Exception
     */
    @Test
    public void testSpittle () throws Exception {
        Spittle spittle = new Spittle("hello", new Date());
        SpittleRepository spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.findOne(12345)).thenReturn(spittleRepository);

        SpittleController spittleController = new SpittleController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(spittleController).build();

        //通过路径请求资源
        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittles"))
                //断言期望的值
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittle", spittle));
    }

    /**
     * 升级版，采用分页
     * 程序清单5.11 用来测试分页spittle列表的新方法
     */
    //@Test
    //public void shouldShowRecentSpittles () throws Exception {
    //
    //    List<Spittle> spittles = createSpittleList(50);
    //    //mockRepository
    //    SpittleRepository mockRepository = mock(SpittleRepository.class);
    //    //预期的Max与count
    //    when(mockRepository.findSpittles(23890, 50)).thenReturn(spittles);
    //
    //    SpittleController controller = new SpittleController (mockRepository);
    //    //mockSpringMVC
    //    MockMvc mockMvc = standaloneSetup(controller)
    //            .setSingleView(new InternalResourceView("WEB-INF/views/spittles.jsp"))
    //            .build();
    //    //对"/spittles"发起GET请求,传入max与count的参数
    //    mockMvc.perform(get("/spittles?max=23890&count=50"))
    //            .andExpect(view().name("spittles"))
    //            //断言期望的值
    //            .andExpect(model().attributeExists("spittleList"))
    //            .andExpect(model().attribute("spittleList", hasItems(spittles.toArray())));
    //}

    /**
     * 最初版
     * 程序清单5.9 测试SpittleController处理针对/spittles 的GET请求
     */
    //@Test
    //public void shouldShowRecentSpittles1 () throws Exception {
    //
    //    List<Spittle> spittles = createSpittleList(20);
    //    //mockRepository
    //    SpittleRepository mockRepository = mock(SpittleRepository.class);
    //    when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(spittles);
    //
    //    SpittleController controller = new SpittleController (mockRepository);
    //    //mockSpringMVC
    //    MockMvc mockMvc = standaloneSetup(controller)
    //            .setSingleView(new InternalResourceView("WEB-INF/views/spittles.jsp"))
    //            .build();
    //    //对"/spittles"发起GET请求
    //    mockMvc.perform(get("/spittles"))
    //            .andExpect(view().name("spittles"))
    //            //断言期望的值
    //            .andExpect(model().attributeExists("spittleList"))
    //            .andExpect(model().attribute("spittleList", hasItems(spittles.toArray())));
    //}

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle" + i, new Date()));
        }
        return spittles;
    }
}