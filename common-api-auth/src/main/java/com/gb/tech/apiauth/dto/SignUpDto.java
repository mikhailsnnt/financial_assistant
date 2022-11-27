package com.gb.tech.apiauth.dto;

import lombok.Data;
import lombok.val;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class SignUpDto {

    @NotEmpty(message = "email не должен быть пустым")
    @Email
    private String email;

    private String password;

}
