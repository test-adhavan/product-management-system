package com.demo.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> product(ProductNotFoundException e){

      String mes  =  e.getMessage();
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mes);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> Category(CategoryNotFoundException e){

        String mes  =  e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mes);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> valid(MethodArgumentNotValidException e){

        Map<String,String> error = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(errors ->
                error.put(errors.getField(),errors.getDefaultMessage()) );

        return error;
    }



}
