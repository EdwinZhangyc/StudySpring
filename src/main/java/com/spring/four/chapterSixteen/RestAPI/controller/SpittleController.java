package com.spring.four.chapterSixteen.RestAPI.controller;

import com.spring.four.chapterSixteen.RestAPI.data.SpittleRepository;
import com.spring.four.chapterSixteen.RestAPI.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 程序清单16.1 实现RESTful功能的Spring MVC控制器
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING="9223372036854775807";

    @Autowired
    private SpittleRepository spittleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count
    ){
        return spittleRepository.findSpittles(max, count);
    }
}