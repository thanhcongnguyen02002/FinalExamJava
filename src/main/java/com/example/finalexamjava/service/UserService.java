package com.example.finalexamjava.service;

import com.example.finalexamjava.model.User;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUserName(String username);
    User findByUserwithName(String username);
    List<User> findAll();
    User create(User user);
    User save(User user);

}
