package ru.gb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gb.dtos.UserDto;
import ru.gb.entities.User;

@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toUser(UserDto userDto);

    UserDto fromUser(User user);

}
