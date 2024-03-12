package com.turkcell.bootcamp.e_commerce.core.exception.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
