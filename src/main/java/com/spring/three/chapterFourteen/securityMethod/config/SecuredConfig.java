package com.spring.three.chapterFourteen.securityMethod.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
//如果将securedEnable设置为ture将会创建一个切点，这样Spring Security切面就会包装带有@Secured注解的方法
@EnableGlobalMethodSecurity(securedEnabled = true)
//如果将jsr250Enabled设置为ture将会使用@RolesAllowed注解，他与securedEnabled不冲突可以一起使用
//@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecuredConfig extends GlobalMethodSecurityConfiguration{

    //在web层的安全配置中设置认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}