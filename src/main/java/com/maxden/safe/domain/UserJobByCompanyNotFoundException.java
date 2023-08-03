package com.maxden.safe.domain;

public class UserJobByCompanyNotFoundException extends RuntimeException {

    public UserJobByCompanyNotFoundException(Long id) {
        super("The user job with company id " + id + " was not found.");
    }
}
