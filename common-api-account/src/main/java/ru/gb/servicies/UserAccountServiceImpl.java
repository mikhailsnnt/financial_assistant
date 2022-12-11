package ru.gb.servicies;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.entities.UserAccount;
import ru.gb.exceptions.ResourceNotFoundException;
import ru.gb.repositories.UserAccountRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    @Override
    public UserAccount getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No userAccount with " + id + "was found"));
    }

    @Override
    public void save(UserAccount userAccount) {
        repository.save(userAccount);
    }

    @Transactional
    @Override
    public void update(UserAccount userAccount) {
        if (!repository.existsById(userAccount.getId())) {
            throw new ResourceNotFoundException("User was not found");
        }
        repository.save(userAccount);
    }


    @Override
    @Transactional
    public void delete(Long id) {
        UserAccount userAccount = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User with id:" + id + " not found"));
        repository.delete(userAccount);
    }
}
