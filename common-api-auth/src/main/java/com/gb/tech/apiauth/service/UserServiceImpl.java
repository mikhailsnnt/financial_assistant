package com.gb.tech.apiauth.service;

import com.gb.financial.assistant.lib.exception.security.ResourceNotFoundException;
import com.gb.tech.apiauth.dto.UserDto;
import com.gb.tech.apiauth.entity.User;
import com.gb.tech.apiauth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl {

    private UserRepository userRepository;

    public UserDto getById(Long id) {
        return userRepository
                .findById(id)
                .map(this::mapToDto)
                .orElseThrow(() ->new ResourceNotFoundException("User " + id + " is not found"));
    }

    public long save(User user) {
        userRepository.save(user);
        return user.getId();
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    private UserDto mapToDto(User entity){
        return new UserDto(entity.getId(),entity.getEmail());
    }
}
