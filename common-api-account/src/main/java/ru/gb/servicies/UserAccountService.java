package ru.gb.servicies;

import ru.gb.entities.UserAccount;

public interface UserAccountService {

    UserAccount getById(Long id);

    void save(UserAccount userAccount);

    void update(UserAccount userAccount);

    void delete(Long id);

}
