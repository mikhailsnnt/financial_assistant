package com.gb.tech.apiauth.service;

import com.gb.tech.apiauth.entity.User;

import java.util.Optional;

public interface UserService {
    User getById(Long id);

    void save(User user);

    void delete(Long id);

    Optional<User> findByEmail(String email);
}
