package ru.gb.servicies;


import com.gb.financial.assistant.lib.data.account.AccountDto;
import com.gb.financial.assistant.lib.data.account.AccountUpdateDto;

import java.util.List;

public interface AccountService {

    AccountDto getById(long id, long userId);

    List<AccountDto> getAll(long userId);

     long save(AccountUpdateDto updateDto, long userId);

     void update(long id, AccountUpdateDto updateDto, long userId);

    void delete(long id, long userId);
}
