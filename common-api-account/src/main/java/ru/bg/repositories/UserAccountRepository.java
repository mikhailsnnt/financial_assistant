package ru.bg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bg.entetities.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {


}
