package com.lanny.hello.service;

import com.lanny.hello.dao.UserRepository;
import com.lanny.hello.dao.entity.Account;
import com.lanny.hello.dao.entity.Authority;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.util.DigestUtils;

import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Set;

import static com.lanny.hello.constants.GlobalConstant.ADMIN_USER;
import static com.lanny.hello.constants.GlobalConstant.SALT;

@Slf4j
public class MiniProgramUserDetails extends JdbcUserDetailsManager {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public MiniProgramUserDetails(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        if (ADMIN_USER.equals(username) || super.userExists(username)) {
            return super.loadUserByUsername(username);
        }

        String password = DigestUtils.md5DigestAsHex((username + SALT).getBytes());
        log.info("Origin password is password {}", password);
        Account account = createSimpleAccount(username, password);
        return account.toSecurityUser();
    }

    private Account createSimpleAccount(String username, String password) {
        Authority authority = Authority.builder()
                .authority(Account.UserType.SIMPLE.toString())
                .username(username)
                .build();

        Set<Authority> authorities = new HashSet<>();
        authorities.add(authority);

        Account account = Account.builder()
                .enabled(true)
                .password(passwordEncoder.encode(password))
                .username(username)
                .type(Account.UserType.SIMPLE)
                .authorities(authorities)
                .build();

        userRepository.save(account);
        return account;
    }
}
