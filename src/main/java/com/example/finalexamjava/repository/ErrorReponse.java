package com.example.finalexamjava.repository;

public record ErrorReponse(
        int status,
        String code,
        String message,
        String description
) {
}
