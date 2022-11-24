package ru.bg.servicies;

import ru.bg.dtos.UserAccountDto;

public interface UserAccountService {

    UserAccountDto getById(Long id);

    void save(UserAccountDto userAccountDto);

    void delete(Long id);

}
