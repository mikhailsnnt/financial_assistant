package com.gb.tech.apiauth.controller;

import com.gb.tech.apiauth.dto.AuthDto;
import com.gb.tech.apiauth.dto.SignUpDto;
import com.gb.tech.apiauth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<AuthDto> signup(@RequestBody SignUpDto signUpDto)  {
        return ResponseEntity.ok(authenticationService.signUp(signUpDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDto> login(@RequestBody SignUpDto loginDto) {
            return ResponseEntity.ok(authenticationService.logIn(loginDto));
        }
}
