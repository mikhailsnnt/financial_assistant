package com.gb.tech.apiauth.service;

import com.gb.financial.assistant.lib.exception.security.ResourceNotFoundException;
import com.gb.tech.apiauth.entity.User;
import com.gb.tech.apiauth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp {

    private UserRepository userRepository;

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("User " + id + " is not found"));
    }

    public Long save(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
