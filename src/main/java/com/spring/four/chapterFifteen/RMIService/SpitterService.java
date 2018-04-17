package com.spring.four.chapterFifteen.RMIService;

import com.spring.four.chapterFifteen.RMIService.domain.Spitter;
import com.spring.four.chapterFifteen.RMIService.domain.Spittle;

import java.util.List;

/**
 * 程序清单15.1 SpitterService定义了Spittr应用的服务层
 */
public interface SpitterService {

    List<Spitter> getRecentSpitters(int count);
    void saveSpittle(Spittle spittle);

}
