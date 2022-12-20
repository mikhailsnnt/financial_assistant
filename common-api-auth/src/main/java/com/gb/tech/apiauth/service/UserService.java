package com.gb.tech.apiauth.service;

import com.gb.tech.apiauth.dto.UserDto;
import com.gb.tech.apiauth.entity.User;

import java.util.Optional;

public interface UserService {
    UserDto getById(Long id);


    void delete(Long id);

    Optional<UserDto> findByEmail(String email);
}
