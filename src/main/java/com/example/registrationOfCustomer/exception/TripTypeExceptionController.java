package com.example.registrationOfCustomer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TripTypeExceptionController {
    @ExceptionHandler(value = TripTypeNotFoundException.class)
    public ResponseEntity<Object> exception(TripTypeNotFoundException exception) {
        return  new ResponseEntity<>("tripTypeNotFound", HttpStatus.NOT_FOUND);
    }
}
