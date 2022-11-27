package com.gb.tech.apiauth.entity;


import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Builder
@Entity
@Table(name = "user_credentials")
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "salt")
    @Size(max = 8)
    private String salt;

    @Column(name = "hash")
    @Size(max = 255)
    private String hash;
}
