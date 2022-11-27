package com.gb.financial.assistant.lib.exception.security;

public class BadCredentialsException extends RuntimeException{
    public BadCredentialsException(String message) {
        super(message);
    }
}
