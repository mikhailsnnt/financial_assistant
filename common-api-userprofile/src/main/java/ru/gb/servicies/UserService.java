package ru.gb.servicies;

import ru.gb.entities.User;

public interface UserService {
    User getById(Long id);

    void save(User user);

    void delete(Long id);
}
