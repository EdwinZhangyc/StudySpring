package com.spring.three.chapterFourteen.securityMethod;

import com.spring.three.chapterFourteen.securityMethod.domain.Spittle;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import java.io.Serializable;

/**
 * 程序清单14.1 permission evaluator 为hasPermission()提供实现逻辑
 */
public class SpitterPermissionEvaluator implements PermissionEvaluator {

    private static final GrantedAuthority ADMIN_AUTHORITY =
            new GrantedAuthorityImpl("ROLE_ADMIN");

    @Override
    public boolean hasPermission(Authentication authentication,
                         Object targetDomainObject, Object permission) {

        Spittle spittle = (Spittle)targetDomainObject;
        String username = spittle.getSpitter().getUsername();
        if ("delete".equals(permission)) {
            return isAdmin(authentication) ||
                    username.equals(authentication.getName());
        }

        throw new UnsupportedOperationException(
                "hasPermission not supported for object < " + targetDomainObject
                + "> and permission <" + permission + ">");

    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().contains(ADMIN_AUTHORITY);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        throw new UnsupportedOperationException();
    }


}