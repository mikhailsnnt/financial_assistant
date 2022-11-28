package ru.gb.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FOException extends Exception {

    private String message;

    public FOException(String message) {
        super(message);
        this.message = new Date() + ": " + message;
    }
}
