package com.gb.tech.apioperation.service;

import com.gb.financial.assistant.lib.data.account.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "common-api-account")
public interface AccountGateway {

    @GetMapping("/account/{id}")
    void getById(@PathVariable("id") long id);

    @GetMapping("/account")
    List<AccountDto> getAll();
}
