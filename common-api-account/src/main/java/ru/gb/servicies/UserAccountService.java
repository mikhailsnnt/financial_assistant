package ru.gb.servicies;

import ru.gb.entities.UserAccount;

import java.util.List;

public interface UserAccountService {

    UserAccount getById(Long id);

    List<UserAccount> findAllByUserId(Long id);

    void save(UserAccount userAccount);

    void update(UserAccount userAccount);

    void delete(Long id);

}
