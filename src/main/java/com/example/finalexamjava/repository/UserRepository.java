package com.example.finalexamjava.repository;

import com.example.finalexamjava.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
public interface UserRepository {
    Optional<User> findByUserName(String username);
    List<User> findAll();
    User save(User user);

}
