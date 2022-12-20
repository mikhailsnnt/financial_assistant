package com.gb.tech.apiauth.controller;

import com.gb.tech.apiauth.dto.UserDto;
import com.gb.tech.apiauth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService service;


    @GetMapping
    public UserDto getCurrent() {
        return service.getById(getAuthenticatedUserId());
    }

    @DeleteMapping
    public void delete() {
        service.delete(getAuthenticatedUserId());
    }

    private long getAuthenticatedUserId() {
        return Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
