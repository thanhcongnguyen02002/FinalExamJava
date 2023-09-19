package com.example.finalexamjava.repository.postgres;

import com.example.finalexamjava.model.GroupManager;
import com.example.finalexamjava.repository.GroupRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PgGroupRepositoryImpl  implements GroupRepository {
    GroupJpaRepository jpaRepository;

    @Override
    public List<GroupManager> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<GroupManager> findByName(String name) {
        return jpaRepository.findByGroupName(name);
    }
}
