package com.example.finalexamjava.repository.postgres;

import com.example.finalexamjava.model.User;
import com.example.finalexamjava.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@Component
@Primary
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PgUserRepositoryImpl implements UserRepository {
    UserJpaRepository jpaRepository;

    @Override
    public Optional<User> findByUserName(String username) {
        return jpaRepository.findByUserName(username);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User save(User user) {
        return jpaRepository.save(user);
    }
}
