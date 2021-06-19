package com.riigsoft.exception;

public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String message){
        super(message);
    }
}
