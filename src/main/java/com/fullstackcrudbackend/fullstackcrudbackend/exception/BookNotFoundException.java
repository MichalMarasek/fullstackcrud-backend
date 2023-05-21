package com.fullstackcrudbackend.fullstackcrudbackend.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Could not found book with id: " + id);
    }
}
