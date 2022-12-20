package ru.gb.servicies;

import com.gb.financial.assistant.lib.data.account.AccountDto;
import com.gb.financial.assistant.lib.data.account.AccountUpdateDto;
import com.gb.financial.assistant.lib.data.account.Currency;
import com.gb.financial.assistant.lib.exception.security.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.entities.Account;
import ru.gb.repositories.UserAccountRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserAccountRepository repository;

    @Override
    public List<AccountDto> getAll(long userId) {
        return repository
                .findAllByUserId(userId)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public AccountDto getById(long id, long userId) {
        return mapToDto(retrieveById(id, userId));
    }

    @Override
    public long save(AccountUpdateDto updateDto, long userId) {
        return repository.save(mapToEntity(updateDto, userId)).getUserId();
    }

    @Override
    public void update(long id, AccountUpdateDto updateDto, long userId) {
        Account account = retrieveById(id, userId);
        if (updateDto.getName() != null)
            account.setName(updateDto.getName());
        if (updateDto.getCurrency() != null)
            account.setCurrency(updateDto.getCurrency().name());
        repository.save(account);
    }

    @Override
    public void delete(long id, long userId) {
        repository.delete(retrieveById(id, userId));
    }

    private Account retrieveById(long id, long userId) {
        return repository.findById(id)
                .map(
                        account -> {
                            if (!account.getUserId().equals(userId))
                                throw new BadRequestException(
                                        String.format("Account with id %s not found", id)
                                );
                            return account;
                        }
                )
                .orElseThrow(() -> new BadRequestException(String.format("Account with id %s not found", id)));
    }

    private AccountDto mapToDto(Account entity) {
        return new AccountDto(
                entity.getId(),
                entity.getUserId(),
                entity.getName(),
                Currency.valueOf(entity.getCurrency()));
    }

    private Account mapToEntity(AccountUpdateDto dto, long userId) {
        return new Account(
                null,
                userId,
                dto.getName(),
                dto.getCurrency().name()
        );
    }
}
