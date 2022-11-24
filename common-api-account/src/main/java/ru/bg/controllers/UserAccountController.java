package ru.bg.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bg.dtos.UserAccountDto;
import ru.bg.servicies.UserAccountService;

@RestController
@AllArgsConstructor
@RequestMapping("/userAccount")
public class UserAccountController {
    private final UserAccountService userAccountServiceImpl;

    @GetMapping("/id")
    public UserAccountDto getById(@RequestParam Long id) {
        return userAccountServiceImpl.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserAccountDto userAccountDto) {
        userAccountServiceImpl.save(userAccountDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        userAccountServiceImpl.delete(id);
    }


}
