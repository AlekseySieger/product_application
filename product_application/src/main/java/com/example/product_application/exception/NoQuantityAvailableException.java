package com.example.product_application.exception;

public class NoQuantityAvailableException extends RuntimeException {
    public NoQuantityAvailableException(String errorMessage) {
        super(errorMessage);
    }
}