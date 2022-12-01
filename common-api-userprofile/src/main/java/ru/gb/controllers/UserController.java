package ru.gb.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.dtos.UserDto;
import ru.gb.mappers.UserMapper;
import ru.gb.servicies.UserService;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userServiceImpl;
    private final UserMapper mapper = UserMapper.MAPPER;

    @GetMapping("/id")
    public UserDto getById(@RequestParam Long id) {
        return mapper.fromUser(userServiceImpl.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserDto userDto) {
        userServiceImpl.save(mapper.toUser(userDto));
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        userServiceImpl.delete(id);
    }

}
