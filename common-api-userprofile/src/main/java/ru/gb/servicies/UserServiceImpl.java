package ru.gb.servicies;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.entities.User;
import ru.gb.exceptions.ResourceNotFoundException;
import ru.gb.repositories.UserRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository repository;

    @Override
    public User getById(Long id) {
        return repository.findById(id).orElseThrow(() ->new ResourceNotFoundException("User " + id + " is not found"));
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
