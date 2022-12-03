package com.gb.tech.apiauth.service;


import com.gb.tech.apiauth.dto.AuthDto;
import com.gb.tech.apiauth.dto.SignUpDto;
import com.gb.tech.apiauth.entity.Role;
import com.gb.tech.apiauth.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final TokenService tokenService;
    private final UserServiceImp userService;
    private final PasswordEncoder passwordEncoder;

    public AuthDto signUp(SignUpDto signUpDto) {

        String salt = randomGeneratingString();
        User user = User.builder()
                .email(signUpDto.getEmail())
                .role(Role.USER)
                .salt(salt)
                .hash(passwordEncoder.encode(signUpDto.getPassword().concat(salt)))
                .build();
        userService.save(user);

        Long newUserId = userService.findByEmail(signUpDto.getEmail()).get().getId();
        return generateTokenForUser(newUserId);
    }

    public AuthDto logIn(SignUpDto loginDto){

        User user = userService.findByEmail(loginDto.getEmail()).orElseThrow(()
                -> new BadCredentialsException("Неправильный логин или пароль"));

        if(!passwordEncoder.matches(loginDto.getPassword().concat(user.getSalt()), user.getHash())) {
            throw new BadCredentialsException("Неправильный логин или пароль");
        }
        return generateTokenForUser(user.getId());
    }

    private  AuthDto generateTokenForUser(Long userId)  {
        return tokenService.generateToken(userId);
    }

    public String randomGeneratingString() {
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8);
        return generatedString;
    }
}
