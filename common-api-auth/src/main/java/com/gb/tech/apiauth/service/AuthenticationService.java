package com.gb.tech.apiauth.service;

import com.gb.financial.assistant.lib.exception.security.BadCredentialsException;
import com.gb.tech.apiauth.dto.AuthDto;
import com.gb.tech.apiauth.dto.SignUpDto;
import com.gb.tech.apiauth.entity.Role;
import com.gb.tech.apiauth.entity.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private UserProfileService userProfileService;
    private TokenService tokenService;
    private UserService userService;
    private final PasswordEncoder passwordEncoder;


    public AuthDto signUp(SignUpDto signUpDto) {

        Long newUserId = userProfileService.save(signUpDto.getEmail());    // сохраняем в базе User

        String salt = randomGeneratingString(); //  случайная генерация

        UserCredentials userCredentials = UserCredentials.builder()   // сохраняем в базе UserCredentials
                .userId(newUserId)
                .role(Role.USER)
                .salt(salt)
                .hash(passwordEncoder.encode(signUpDto.getPassword().concat(salt)))
                .build();
        userService.save(userCredentials);

        return generateTokenForUser(newUserId);
    }

    public AuthDto logIn(SignUpDto loginDto){

        UserCredentials userCredentials = userService.findByEmail(loginDto.getEmail()).orElseThrow(()
                -> new BadCredentialsException(String.format("Неправильный логин или пароль")));

        if(!passwordEncoder.matches(loginDto.getPassword().concat(userCredentials.getSalt()), userCredentials.getHash())) {
            throw new BadCredentialsException(String.format("Неправильный логин или пароль"));
        }
        return generateTokenForUser(userCredentials.getUserId());
    }

    private  AuthDto generateTokenForUser(Long userId)  {
        return tokenService.generateToken(userId);
    }

    public String randomGeneratingString() {
        byte[] array = new byte[20];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        return generatedString;
    }
}
