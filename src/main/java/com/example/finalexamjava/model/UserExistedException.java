package com.example.finalexamjava.model;

import com.example.finalexamjava.repository.ErrorCode;
import com.example.finalexamjava.repository.ErrorCodeException;

public class UserExistedException extends ErrorCodeException {
    public UserExistedException(ErrorCode errorCode, String description) {
        super(errorCode, description);
    }
}
