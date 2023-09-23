package com.example.finalexamjava.controller;

public record GroupFilter(
        String groupName,
        Long minId,
        Long maxId,
        Long id
) {
}
