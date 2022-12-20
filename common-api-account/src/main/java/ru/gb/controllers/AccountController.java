package ru.gb.controllers;


import com.gb.financial.assistant.lib.data.account.AccountDto;
import com.gb.financial.assistant.lib.data.account.AccountUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.gb.servicies.AccountService;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping()
    public List<AccountDto> getAllAccounts() {
        return accountService.getAll(getAuthenticatedUserId());
    }

    @GetMapping("/{id}")
    public AccountDto getById(@PathVariable long id) {
        return accountService.getById(id, getAuthenticatedUserId());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long save(@Valid @RequestBody AccountUpdateDto updateDto) {
        return accountService.save(updateDto, getAuthenticatedUserId());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @Valid @RequestBody AccountUpdateDto updateDto) {
        accountService.update(id, updateDto, getAuthenticatedUserId());
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accountService.delete(id, getAuthenticatedUserId());
    }

    private long getAuthenticatedUserId() {
        return Long.parseLong(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
