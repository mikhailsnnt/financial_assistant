package ru.gb.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserAccountExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<FOException> catchResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new FOException(e.getMessage()), HttpStatus.NOT_FOUND);
    }


}
