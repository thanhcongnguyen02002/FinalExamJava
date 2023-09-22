package com.example.finalexamjava.repository.postgres;

import com.example.finalexamjava.controller.GroupFilter;
import com.example.finalexamjava.model.GroupManager;
import com.example.finalexamjava.repository.GroupRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PgGroupRepositoryImpl  implements GroupRepository {
    GroupJpaRepository jpaRepository;

    @Override
    public Page<GroupManager> findAll(GroupFilter filter, Pageable pageable) {

        var spec = GroupSpecification.withFilter(filter);
        return jpaRepository.findAll(spec, pageable);
    }

    @Override
    public Optional<GroupManager> findByName(String name) {
        return jpaRepository.findByGroupName(name);
    }

    @Override
    public GroupManager save(GroupManager groupManager) {
        return jpaRepository.save(groupManager);
    }

    @Override
    public Optional<GroupManager> findById(Long id) {
        return  jpaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }
}
