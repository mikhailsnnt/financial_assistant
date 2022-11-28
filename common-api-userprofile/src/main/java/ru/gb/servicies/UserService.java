package ru.gb.servicies;

import ru.gb.dtos.UserDto;

public interface UserService {
    UserDto getById(Long id);
    void save(UserDto userDto);
    void delete(Long id);
}
