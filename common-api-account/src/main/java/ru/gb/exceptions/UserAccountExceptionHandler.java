package ru.gb.exceptions;


import com.gb.financial.assistant.lib.exception.security.BadAccountIdException;
import com.gb.financial.assistant.lib.exception.security.ResourceNotFoundException;
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

    @ExceptionHandler
    public ResponseEntity<FOException> catchBadAccountIdException(BadAccountIdException e) {
        return new ResponseEntity<>(new FOException(e.getMessage()), HttpStatus.FORBIDDEN);
    }

}
