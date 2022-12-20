package com.gb.tech.apiauth.entity;


import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "salt")
    @Size(max = 8)
    private String salt;

    @Column(name = "hash")
    @Size(max = 255)
    private String hash;
}
