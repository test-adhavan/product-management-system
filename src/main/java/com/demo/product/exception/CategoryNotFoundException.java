package com.demo.product.exception;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String mess){

         super(mess);
    }
}
