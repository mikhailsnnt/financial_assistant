package com.gb.tech.apioperation.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FinancialOperationServiceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AppError> catchInvalidParamsException(InvalidParamsException e) {
        return new ResponseEntity<>(new AppError(ServiceErrors.INVALID_PARAMS.name(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
