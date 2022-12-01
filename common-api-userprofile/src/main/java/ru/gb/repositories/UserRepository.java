package ru.gb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
