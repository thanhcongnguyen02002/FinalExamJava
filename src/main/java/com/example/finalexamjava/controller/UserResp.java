package com.example.finalexamjava.controller;

import com.example.finalexamjava.model.Role;

public record UserResp(
        Long id,
        String name,
        String userName,
        Role role
) {


}
