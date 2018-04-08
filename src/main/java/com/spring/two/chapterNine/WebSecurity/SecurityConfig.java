package com.spring.two.chapterNine.WebSecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

/**
 * 程序清单9.3 配置Spring Security使用内存用户存储
 */
@Configuration
//启动WebMVC安全性
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //单点登陆 remember me
    //@Override
    //protected  void configure (HttpSecurity httpSecurity) throws Exception{
    //
    //    //9.4.3 remember-me  单点登陆
    //    httpSecurity.formLogin()
    //            .loginPage("/login")
    //            .and()
    //            .rememberMe()
    //            .tokenValiditySeconds(233323223)
    //            .key("spitterKey");
    //}

    /**
     * 程序清单9.7 formLogin()方法启动基本登陆页功能，多个设置指令中使用and()相关联
     */
    //@Override
    //protected  void configure (HttpSecurity httpSecurity) throws Exception{
    //    //启动默认登陆页
    //    httpSecurity.formLogin()
    //            .and()
    //            .authorizeRequests()
    //            .antMatchers("/spitter/me").access("hasRole('SPITTER') and hasIpAddress('192.168.1.2')")
    //            .anyRequest().permitAll()
    //            .and()
    //            .requiresChannel()
    //            .antMatchers("/spitter/from").requiresSecure()//需要使用HTTPS
    //            .antMatchers("/").requiresInsecure();//需要使用HTTP
    //}

    /**
     * 程序清单9.5 requiresChannel()方法会为选定的URL强制使用HTTPS
     */
    //@Override
    //protected  void configure (HttpSecurity httpSecurity) throws Exception{
    //
    //    httpSecurity.authorizeRequests()
    //            .antMatchers("/spitter/me").access("hasRole('SPITTER') and hasIpAddress('192.168.1.2')")
    //            .anyRequest().permitAll()
    //            .and()
    //            .requiresChannel()
    //            .antMatchers("/spitter/from").requiresSecure()//需要使用HTTPS
    //            .antMatchers("/").requiresInsecure();//需要使用HTTP
    //}


    ////9.3拦截请求
    @Override
    protected  void configure (HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeRequests()
                .antMatchers("/spitter/me").authenticated()
                //可以使用ant风格的通用符,同时可以指定多个路径
                .antMatchers("/spitter/**", "/spittles").authenticated()
                .antMatchers(HttpMethod.POST, "/spittles").authenticated()
                //用户不仅需要认证，同时需要具备ROLE_SPITER权限
                .antMatchers(HttpMethod.GET, "/test").hasAuthority("ROLE_SPITER")
                //用户不仅需要认证，同时需要具备ROLE_SPITER权限替代方案，可以直接省略ROLE_
                .antMatchers(HttpMethod.GET, "/test").hasRole("SPITER")
                .anyRequest().permitAll();
    }

    //基于自定义模式进行认证
    //@Autowired
    //SpitterRepository spitterRepository;
    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    //    auth.userDetailsService(new SpitterUserService(spitterRepository));
    //}

    //基于LDAP进行认证
    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    //    auth.ldapAuthentication()
    //            .userSearchBase("ou=people")
    //            .userSearchFilter("(uid={0})")
    //            .userSearchBase("ou=grops")
    //            .groupSearchFilter("(member={0})")
    //            //配置密码比对
    //            .passwordCompare()
    //            //如果密码被保存到不同的属性中，可以通过passwordAttribute（）方法来声明属性方法来声明密码属性名称
    //            .passwordEncoder(new Md5PasswordEncoder())
    //            .passwordAttribute("passcode");
    //}

    //基于数据库表进行存储
    //@Autowired
    //DataSource dataSource;
    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    //    auth.jdbcAuthentication().dataSource(dataSource)
    //            .usersByUsernameQuery("select username, password, true from Spitter where username = ?")
    //            .authoritiesByUsernameQuery("select username, 'ROLE_USER' from Spitter where username = ?")
    //            //使用passwordEncoder()方法指定一个密码转码器（encoder）
    //            .passwordEncoder(new StandardPasswordEncoder("scott"));
    //}


    //基于内存用户存储
    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //
    //    //启动内存用户存储
    //    auth.inMemoryAuthentication()
    //            .withUser("user").password("password").roles("USER").and()
    //            .withUser("admin").password("password").roles("USER", "ADMIN");
    //}
}