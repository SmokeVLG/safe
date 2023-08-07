package com.maxden.safe.web;

import com.maxden.safe.domain.exception.UserJobByCompanyNotFoundException;
import com.maxden.safe.domain.exception.UserJobByUserNotFoundException;
import com.maxden.safe.domain.exception.UserJobNoBodyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserJobInfoControllerAdvice {
    @ExceptionHandler(UserJobByUserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userJobNotFoundHandler(UserJobByUserNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UserJobByCompanyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userJobNotFoundHandler(UserJobByCompanyNotFoundException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UserJobNoBodyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String userJobNoBodyHandler(UserJobNoBodyException ex) {
        return ex.getMessage();
    }


}
