package ru.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entities.UserAccount;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    List<UserAccount> findAllByUserId(Long id);
}
