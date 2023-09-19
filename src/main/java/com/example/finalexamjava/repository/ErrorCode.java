package com.example.finalexamjava.repository;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {

    GROUP_NOT_FOUND(404, "GRP-001", "Group not found"),
    UNAUTHORIZED(401, "ACC-002", "Unauthorized"),
    FORBIDDEN(403, "ACC-003", "Forbidden"),
    GROUP_EXISTED(409, "GRP-004", "group existed"),
    INTERNAL_SERVER_ERROR(500, "SYS-001", "Internal server error");

    int status;
    String code;
    String message;
    ErrorCode(int status, String code, String message) {
        this.status=status;
        this.code = code;
        this.message = message;
    }
}
