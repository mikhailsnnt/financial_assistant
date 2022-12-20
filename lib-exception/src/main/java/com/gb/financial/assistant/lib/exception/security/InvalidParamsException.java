package com.gb.financial.assistant.lib.exception.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidParamsException extends RuntimeException {
    public InvalidParamsException(String message) {
        super(message);
    }
}
