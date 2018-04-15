package com.spring.three.chapterFourteen.securityMethod.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
//如果将jsr250Enabled设置为ture将会使用@RolesAllowed注解，他与securedEnabled不冲突可以一起使用
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class JSR250Config extends GlobalMethodSecurityConfiguration {
}