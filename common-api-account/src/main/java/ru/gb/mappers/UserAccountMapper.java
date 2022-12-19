package ru.gb.mappers;


import ru.gb.dtos.UserAccountDto;
import ru.gb.entities.UserAccount;

public class UserAccountMapper {

    public static UserAccount toUserAccount(UserAccountDto userAccountDto) {
        return new UserAccount(userAccountDto.getId(),
                userAccountDto.getUserId(),
                userAccountDto.getName(),
                userAccountDto.getCurrency());
    }

    public static UserAccountDto fromUserAccount(UserAccount userAccount) {
        return new UserAccountDto(userAccount.getId(),
                userAccount.getUserId(),
                userAccount.getName(),
                userAccount.getCurrency());
    }

}
