package com.example.finalexamjava.service;

import com.example.finalexamjava.model.User;
import com.example.finalexamjava.model.UserExistedException;
import com.example.finalexamjava.repository.ErrorCode;
import com.example.finalexamjava.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository repository;
    @Override
    public Optional<User> findByUserName(String username) {
        return repository.findByUserName(username);

    }

    @Override
    public User findByUserwithName(String username) {
        return repository.findByUserName(username).orElseThrow(
                ()-> new UserExistedException(ErrorCode.USER_EXISTED,"user already exists")
        );
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User create(User user) {
        var result = findByUserName(user.getUsername());
        if(result.isPresent()){
            throw new UserExistedException(ErrorCode.USER_EXISTED,"user already exists");
        }
        return repository.save(user);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
