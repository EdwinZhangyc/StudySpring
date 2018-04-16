package com.spring.three.chapterFourteen.securityMethod.service;

import com.spring.three.chapterFourteen.securityMethod.domain.Spitter;
import com.spring.three.chapterFourteen.securityMethod.domain.Spittle;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import java.util.List;

public class ExpressionSpittleService implements SpittleService {

    //方法调用之前进行验证
    @PreAuthorize("hasRole('ROLE_SPITTER' and #spittle.text.length() <= 140)" +
            "or hasRole('ROLE_PREMIUM')")
    public void addSpittle(Spittle spittle) {

    }

    //方法调用之后开始验证
    @PostAuthorize("returnObject.spitter.username == principal.username")
    public Spittle getSpittleById(long id){return null;}

    //事后对方法的返回值进行过滤
    @PreAuthorize("hasAnyRole('ROLE_SPITTER, ROLE_ADMIN')")
    @PostFilter("hasRole('ROLE_ADMIN') ||" +
            "filterObject.spitter.usrname == principal.username")
    public List<Spittle> getOffensiveSpittles() {return null;}

    //事前对参数进行过滤,在参数中，只保留符合权限的数据
    @PreAuthorize("hasAnyRole('ROLE_SPITTER, ROLE_ADMIN')")
    @PreFilter("hasRole('ROLE_ADMIN') ||" +
            //targetObject是Spring Security提供的另外一个值，他表示要计算当前列表元素
            "targetObject.spitter.username == principal.username")
    public void daleteSpittles(List<Spitter> spitters){}

    //自定义permission evaluator 简化SqEL语言
    @PreAuthorize("hasAnyRole('ROLE_SPITTER, ROLE_ADMIN')")
    @PreFilter("hasPermission(targetObject, 'delete')")
    public void deleteSpittels(List<Spittle> spittles){}




}