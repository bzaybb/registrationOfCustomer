package com.example.registrationOfCustomer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RegistrationExceptionController {
    @ExceptionHandler(value = RegistrationNotFoundException.class)
    public ResponseEntity<Object> exception(RegistrationNotFoundException exception) {
        return  new ResponseEntity<>("RegistrationNotFound", HttpStatus.NOT_FOUND);
    }
}
