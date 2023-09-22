package com.example.finalexamjava.controller;

import com.example.finalexamjava.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public record UserReq(
        @NotBlank
        String name,
        @NotBlank
        String userName,
        @NotBlank
        String password,
        Role role

) {
}
