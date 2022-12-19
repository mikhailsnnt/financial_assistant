package ru.gb.controllers;


import com.gb.financial.assistant.lib.exception.security.BadAccountIdException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.gb.dtos.UserAccountDto;
import ru.gb.entities.UserAccount;
import ru.gb.mappers.UserAccountMapper;
import ru.gb.servicies.UserAccountService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class UserAccountController {


    private final UserAccountService userAccountServiceImpl;

    @GetMapping()
    public List<UserAccountDto> getAllAccounts() {
        List<UserAccountDto> accountDtos = new ArrayList<>();
        for (UserAccount userAccount : userAccountServiceImpl
                .findAllByUserId(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()))) {
            accountDtos.add(UserAccountMapper.fromUserAccount(userAccount));
        }
        return accountDtos;
    }

    @GetMapping("/{id}")
    public UserAccountDto getById(@PathVariable Long id) {
        UserAccount userAccount = userAccountServiceImpl.getById(id);
        if (!userAccount.getUserId().equals(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()))) {
            throw new BadAccountIdException("Wrong user id for this account!");
        }
        return UserAccountMapper.fromUserAccount(userAccount);
    }

    @PostMapping
    public void save(@RequestBody UserAccountDto userAccountDto) {
        userAccountServiceImpl.save(UserAccountMapper.toUserAccount(userAccountDto));
    }

    @PutMapping
    public void update(@RequestBody UserAccountDto userAccountDto) {
        userAccountServiceImpl.update(UserAccountMapper.toUserAccount(userAccountDto));
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userAccountServiceImpl.delete(id);
    }


}
