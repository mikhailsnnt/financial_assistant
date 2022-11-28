package ru.gb.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gb.dtos.UserAccountDto;
import ru.gb.entities.UserAccount;

@Mapper
public interface UserAccountMapper {

    UserAccountMapper MAPPER = Mappers.getMapper(UserAccountMapper.class);

    UserAccount toUserAccount(UserAccountDto userAccountDto);

    UserAccountDto fromUserAccount(UserAccount userAccount);

}
