package ru.gb.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.dtos.UserAccountDto;
import ru.gb.mappers.UserAccountMapper;
import ru.gb.servicies.UserAccountService;

@RestController
@AllArgsConstructor
@RequestMapping("/userAccount")
public class UserAccountController {

    private final UserAccountMapper mapper = UserAccountMapper.MAPPER;
    private final UserAccountService userAccountServiceImpl;

    @GetMapping("/id")
    public UserAccountDto getById(@RequestParam Long id) {
        return   mapper.fromUserAccount(userAccountServiceImpl.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody UserAccountDto userAccountDto) {
        userAccountServiceImpl.save(mapper.toUserAccount(userAccountDto));
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        userAccountServiceImpl.delete(id);
    }


}
