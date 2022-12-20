package ru.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entities.Account;

import java.util.List;

public interface UserAccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAllByUserId(Long id);
}
