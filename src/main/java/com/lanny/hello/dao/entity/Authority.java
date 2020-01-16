package com.lanny.hello.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auth_id")
    private Integer id;

    @Column
    private String username;

    @Column
    private String authority;

}
