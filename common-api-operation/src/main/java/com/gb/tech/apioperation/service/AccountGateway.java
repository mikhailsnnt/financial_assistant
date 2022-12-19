package com.gb.tech.apioperation.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "common-api-account")
public interface AccountGateway {

    @GetMapping("/account/{id}")
    void getById(@PathVariable("id") Long id);

    @GetMapping("/account/accountid/{id}")
    //TODO AccountDto
    List<Object> getAll(@PathVariable("id") Long id);
}
