package com.gb.financial.assistant.lib.exception.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class BadAccountIdException extends RuntimeException {
    public BadAccountIdException(String message) {
        super(message);
    }
}
