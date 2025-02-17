package com.example.banksystem2.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobaleExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handelException(Exception e){
        return ResponseEntity.status(500).body(e.getMessage());
    }
    
}
