package ru.gb.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_accounts")
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name="name")
    private String name;

    @Column(name="currency")
    private String currency;


}
