package com.example.finalexamjava.model;

import com.example.finalexamjava.repository.ErrorCode;
import com.example.finalexamjava.repository.ErrorCodeException;

public class GroupNotFoundException extends ErrorCodeException {
    public GroupNotFoundException(ErrorCode errorCode, String description) {
        super(errorCode, description);
    }
}
