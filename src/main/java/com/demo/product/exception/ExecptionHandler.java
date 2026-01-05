package com.demo.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExecptionHandler {

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<String> product(ProductNotFound e){

      String mes  =  e.getMessage();
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mes);
    }

    @ExceptionHandler(CategoryNotFound.class)
    public ResponseEntity<String> Category(CategoryNotFound e){

        String mes  =  e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mes);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> vaild(MethodArgumentNotValidException e){

        Map<String,String> error = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(errors ->
                error.put(errors.getField(),errors.getDefaultMessage()) );

        return error;
    }



}
