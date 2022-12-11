package ru.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

}
