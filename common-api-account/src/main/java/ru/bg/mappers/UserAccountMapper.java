package ru.bg.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.bg.dtos.UserAccountDto;
import ru.bg.entetities.UserAccount;

@Mapper
public interface UserAccountMapper {

    UserAccountMapper MAPPER = Mappers.getMapper(UserAccountMapper.class);

    UserAccount toUserAccount(UserAccountDto userAccountDto);
    UserAccountDto fromUserAccount(UserAccount userAccount);



//    UserMapper MAPPER  = Mappers.getMapper(UserMapper.class);
//
//    User toUser(UserDto userDto);
//    UserDto fromUser(User user);

}
