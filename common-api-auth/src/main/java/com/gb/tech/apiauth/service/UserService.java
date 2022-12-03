package com.gb.tech.apiauth.service;

import com.gb.tech.apiauth.entity.UserCredentials;
import com.gb.tech.apiauth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Transactional
    public void save(UserCredentials userCredentials) {
        userRepository.save(userCredentials);
    }

    public Optional<UserCredentials> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
