package com.gb.financial.assistant.lib.exception.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class JwtTokenExpiredException extends RuntimeException {
    public JwtTokenExpiredException() {
        super("Jwt token is expired");
    }
}
