package com.gb.tech.apiauth.mapper;

import com.gb.tech.apiauth.dto.UserDto;
import com.gb.tech.apiauth.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    User toUser(UserDto userDto);

    UserDto fromUser(User user);

}
