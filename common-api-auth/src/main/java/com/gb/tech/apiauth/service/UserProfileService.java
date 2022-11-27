package com.gb.tech.apiauth.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//("COMMON-API-USER")
@FeignClient(value = "COMMON-API-AUTH", url="http://localhost:8084/user")
public interface UserProfileService {

    @PostMapping("/user")
    Long save(String email);
}
