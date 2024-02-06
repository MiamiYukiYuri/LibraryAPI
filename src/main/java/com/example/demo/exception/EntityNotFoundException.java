package com.example.demo.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super("This book is not available for lending at the moment");
    }
}
