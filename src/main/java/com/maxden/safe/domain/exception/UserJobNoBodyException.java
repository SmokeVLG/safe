package com.maxden.safe.domain.exception;

public class UserJobNoBodyException extends RuntimeException {

    public UserJobNoBodyException() {
        super("Query is required.");
    }
}
