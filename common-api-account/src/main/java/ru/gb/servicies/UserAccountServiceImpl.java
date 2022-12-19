package ru.gb.servicies;

import com.gb.financial.assistant.lib.exception.security.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.entities.UserAccount;
import ru.gb.repositories.UserAccountRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;

    @Override
    public List<UserAccount> findAllByUserId(Long id) {
        return repository.findAllByUserId(id);
    }

    @Override
    public UserAccount getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No userAccount with " + id + "was found"));
    }

    @Override
    public void save(UserAccount userAccount) {
        repository.save(userAccount);
    }

    @Override
    public void update(UserAccount userAccount) {
        if (!repository.existsById(userAccount.getId())) {
            throw new ResourceNotFoundException("User was not found");
        }
        repository.save(userAccount);
    }

    @Override
    public void delete(Long id) {
        UserAccount userAccount = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("User with id:" + id + " not found"));
        repository.delete(userAccount);
    }
}
