package com.spring.three.chapterFourteen.securityMethod.service;

import com.spring.three.chapterFourteen.securityMethod.domain.Spittle;

import javax.annotation.security.RolesAllowed;

public class JSR250SpittleService implements SpittleService {
    @Override
    /**
     * 添加权限校验注解，作用与@Secured一样，唯独的优势，@Secured基于spring的注解
     * 而@RolesAllowed是基于java的注解，当不使用spring框架时@RolesAllowed更加有优势
     */
    @RolesAllowed("ROLE_SPITTER")
    public void addSpittle(Spittle spittle) {

    }
}