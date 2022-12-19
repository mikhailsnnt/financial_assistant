package com.gb.tech.apioperation.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "common-api-account")
public interface AccountGateway {

    @GetMapping("/account/userid/{id}")
    Long getUserId(@PathVariable("id") Long id);

    @GetMapping("/account/accountid/{id}")
    Long getAccountId(@PathVariable("id") Long id);
}
