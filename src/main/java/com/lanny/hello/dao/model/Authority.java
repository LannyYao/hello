package com.lanny.hello.dao.model;

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
    @GeneratedValue
    @Column(name = "auth_id")
    private Integer id;

    @Column
    private String username;

    @Column
    private String authority;

}
