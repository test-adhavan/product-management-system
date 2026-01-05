package com.demo.product.exception;

public class CategoryNotFound extends RuntimeException {

    public CategoryNotFound(String mess){

         super(mess);
    }
}
