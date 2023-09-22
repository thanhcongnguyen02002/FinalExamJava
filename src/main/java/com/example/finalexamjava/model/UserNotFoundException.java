package com.example.finalexamjava.model;

import com.example.finalexamjava.repository.ErrorCode;
import com.example.finalexamjava.repository.ErrorCodeException;

public class UserNotFoundException extends ErrorCodeException {
    public UserNotFoundException(ErrorCode errorCode, String description) {
        super(errorCode, description);
    }
}
