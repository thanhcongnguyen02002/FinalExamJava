package com.example.finalexamjava.model;

import com.example.finalexamjava.repository.ErrorCode;
import com.example.finalexamjava.repository.ErrorCodeException;

public class GroupExistedException extends ErrorCodeException {

    public GroupExistedException(ErrorCode errorCode, String description) {
        super(errorCode, description);
    }
}
