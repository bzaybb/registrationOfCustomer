package com.example.registrationOfCustomer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice //handles all exception
public class RegistrationExceptionController {
    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<Object> exception(CustomerNotFoundException exception){
        return new ResponseEntity<>("Customer Not Found", HttpStatus.NOT_FOUND);
    }
}
