package ru.gb.servicies;

import ru.gb.entities.UserAccount;

public interface UserAccountService {

    UserAccount getById(Long id);

    void save(UserAccount userAccountDto);

    void delete(Long id);

}
