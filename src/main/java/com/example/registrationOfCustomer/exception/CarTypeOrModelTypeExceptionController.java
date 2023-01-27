package com.example.registrationOfCustomer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarTypeOrModelTypeExceptionController {
    @ExceptionHandler(value = CarTypeOrCarModelNotFoundException.class)
    public ResponseEntity<Object> exception(CarTypeOrCarModelNotFoundException exception) {
        return  new ResponseEntity<>("CarTypeOrCarModelNotFound", HttpStatus.NOT_FOUND);
    }
}
