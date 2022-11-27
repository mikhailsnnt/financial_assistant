package com.gb.tech.apioperation.exeptions;

public class InvalidParamsException extends RuntimeException {
    public InvalidParamsException(String message) {
        super(message);
    }
}
