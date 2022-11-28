package ru.gb.servicies;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.entities.UserAccount;
import ru.gb.exceptions.ResourceNotFoundException;
import ru.gb.repositories.UserAccountRepository;

@Service
@AllArgsConstructor
public class UserAccountServiceImpl implements UserAccountService{

    private final UserAccountRepository repository;

    @Override
    public UserAccount getById(Long id) {
        UserAccount userAccount = repository.findById(id)
                .orElseThrow(new ResourceNotFoundException("No userAccount with " + id + "was found"));
        return userAccount;
    }

    @Override
    public void save(UserAccount userAccount) {
        repository.save(userAccount);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
