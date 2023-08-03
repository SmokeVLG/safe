package com.maxden.safe.domain;

public class UserJobNoBodyException extends RuntimeException {

    public UserJobNoBodyException() {
        super("Query is required.");
    }
}
