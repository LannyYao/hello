package com.lanny.hello.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author yao lang
 * @version 1.0
 * @date 2020/1/9 17:00
 */
@Slf4j
@Component
public class AuthUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("收到用户 -> [{}]", username);

        return new User(username, "pwd", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
