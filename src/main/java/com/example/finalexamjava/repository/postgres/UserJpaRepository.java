package com.example.finalexamjava.repository.postgres;

import com.example.finalexamjava.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.nio.file.LinkOption;
import java.util.Optional;


public interface UserJpaRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String name);
}
