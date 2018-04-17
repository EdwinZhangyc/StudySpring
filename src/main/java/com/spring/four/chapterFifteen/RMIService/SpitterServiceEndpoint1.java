package com.spring.four.chapterFifteen.RMIService;

import com.spring.four.chapterFifteen.RMIService.domain.Spitter;
import com.spring.four.chapterFifteen.RMIService.domain.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * 程序清单15.3 SimpleJaxWsServiceExporter将bean转变为JAX-WS端点
 */
@Component
@WebService(serviceName = "SpitterService")
public class SpitterServiceEndpoint1 extends SpringBeanAutowiringSupport {//启动自动装配

    //自动装配SpitterService
    @Autowired
    SpitterService spitterService;

    //以下均是委托给SpitterService
    @WebMethod
    public void saveSpittle (Spittle spittle){
        spitterService.saveSpittle(spittle);
    }
    //委托给SpitterService
    @WebMethod
    public List<Spitter> getRecentSpitters(int count) {
        return spitterService.getRecentSpitters(count);
    }
}