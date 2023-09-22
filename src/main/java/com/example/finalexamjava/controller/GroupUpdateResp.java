package com.example.finalexamjava.controller;

import jakarta.validation.constraints.Size;

public record GroupUpdateResp(
        @Size(min = 3, max = 50, message = "groupname is invalid ")
        String groupName
) {
}
