package com.example.cats.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CatNotFound.class)
    public ResponseEntity<Error> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(CatAlreadyExists.class)
    public ResponseEntity<Error> handleExists() {
        return ResponseEntity.notFound().build();
    }




}
