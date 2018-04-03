package com.spring.two.chapterNine.WebSecurity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * 程序清单9.4 从SpitterRepository中查找UserDetails对象
 */
public class SpitterUserService implements UserDetailsService {

    private final SpitterRepository spitterRepository;
    //注入SpitterRepository
    public SpitterUserService (SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查找spitter
        Spitter spitter = spitterRepository.findByUserName(username);
        if(spitter != null) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            //创建权限列表
            authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
            return new User(spitter.getUserName(),
                            spitter.getPassWord(),
                            authorities);
        }
        throw new UsernameNotFoundException("USER"+ username+ "not Found");
    }
}