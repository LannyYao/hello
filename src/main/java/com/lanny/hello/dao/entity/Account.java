package com.lanny.hello.dao.entity;

import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Boolean enabled;

    @Column
    private String email;

    @Column
    private UserType type;

    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    public enum UserType {
        ADMIN,  //对应数据库里的0
        SIMPLE  //对应数据库里的1
    }

    public User toSecurityUser() {
        return new User(username,
                password,
                Collections.singletonList(new SimpleGrantedAuthority(UserType.ADMIN.toString()))
        );
    }
}
