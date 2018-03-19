package com.spring.two.chapterFive.buildSpringWeb.modelDatatoView;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.ws.api.model.MEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);

    //注入spittleRepository
    @Autowired
    public SpittleController (SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }


    /**
     * public String spittles（）与public List<Spittle> spittles ()方法是程序清单5.9的代码
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        /*model.addAttribute(//将spittle添加到模型中
                spittleRepository.findSpittles(Long.MAX_VALUE, 20));*/
        //与上面表示的是一个意思
        model.addAttribute(//将spittle添加到模型中
                "spittleList",
                spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        //返回视图名
        return "spittles";
    }
    //同时上述方法可以使用该种方式进行替代
    //不同返回模版名称，由于再类上生明类@RequestMapping("/spittles")，所以会自动寻找spittles的jsp
    //详情见5.2.3
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles () {
        return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
    }


    /**
     * 分页通过查询参数来处理请求
     * 与下面带有默认值得方法都为程序清单5.11 对应的代码
     * 详情见5.3.1
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam("max") long max,
            @RequestParam("count") int count
    ){
        return spittleRepository.findSpittles(max, count);
    }
    //分页赋予默认值 通过查询参数来处理请求
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles1(
            @RequestParam(value = "max",
                          defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count",
                          defaultValue = "20") int count
    ){
        return spittleRepository.findSpittles(max, count);
    }

    /**
     * 通过路径参数接受输入
     * 与下面方法都是程序清单5.12对应的代码
     * 详情见5.3.2
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle (
            @RequestParam("spittle_id") long spittleId,
            Model model
    ) {
                model.addAttribute(spittleRepository.findOne(spittleId));
                return "spittle";
    }
    //将路径设置为动态的
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String showSpittle (
            @PathVariable("spittleId") long spittleId,
            //@PathVariable括号里的内容可写可不写。不写的意思表示与RequestMapping中的值一致，简化代码
            //@PathVariable long spittleId,
            Model model
    ) {
                model.addAttribute(spittleRepository.findOne(spittleId));
                return "spittle";
    }
}