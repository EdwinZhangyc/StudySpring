package com.spring.three.chapterFourteen.securityMethod.service;

import com.spring.three.chapterFourteen.securityMethod.domain.Spittle;
import org.springframework.security.access.annotation.Secured;

public class SecuredSpittleService implements SpittleService {

    @Override
    @Secured({"ROLE_SPITTER", "ROLE_ADMIN"})//添加权限,可以添加多个权限，需要至少满足其中一个权限，才能执行方法
    public void addSpittle(Spittle spittle) {

    }
}