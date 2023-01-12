package com.gb.tech.apiauth.entity;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
