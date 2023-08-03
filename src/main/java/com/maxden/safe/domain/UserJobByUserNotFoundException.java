package com.maxden.safe.domain;

public class UserJobByUserNotFoundException extends RuntimeException {

    public UserJobByUserNotFoundException(Long id) {
        super("The user job with user id " + id + " was not found.");
    }
}
