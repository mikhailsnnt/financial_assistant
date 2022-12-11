package ru.gb.controllers;


import lombok.AllArgsConstructor;
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

    @GetMapping("/{id}")
    public UserAccountDto getById(@PathVariable Long id) {
        return mapper.fromUserAccount(userAccountServiceImpl.getById(id));
    }

    @PostMapping
    public void save(@RequestBody UserAccountDto userAccountDto) {
        userAccountServiceImpl.save(mapper.toUserAccount(userAccountDto));
    }

    @PutMapping
    public void update(@RequestBody UserAccountDto userAccountDto) {
        userAccountServiceImpl.update(mapper.toUserAccount(userAccountDto));
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userAccountServiceImpl.delete(id);
    }


}
