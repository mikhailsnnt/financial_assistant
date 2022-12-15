package com.gb.tech.apiauth.controller;

import com.gb.tech.apiauth.dto.UserDto;
import com.gb.tech.apiauth.mapper.UserMapper;
import com.gb.tech.apiauth.service.UserServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserServiceImp userServiceImpl;
    private final UserMapper mapper = UserMapper.MAPPER;

    @GetMapping("/id")
    public UserDto getById(@RequestParam Long id) {
        return mapper.fromUser(userServiceImpl.getById(id));
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        userServiceImpl.delete(id);
    }
}
