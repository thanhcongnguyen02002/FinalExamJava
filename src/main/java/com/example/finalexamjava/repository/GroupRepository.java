package com.example.finalexamjava.repository;

import com.example.finalexamjava.controller.GroupFilter;
import com.example.finalexamjava.model.GroupManager;
import com.example.finalexamjava.repository.postgres.GroupJpaRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface GroupRepository  {
    Page<GroupManager > findAll(GroupFilter filter, Pageable pageable);
    Optional<GroupManager> findByName(String name);
    GroupManager save(GroupManager groupManager);
    Optional<GroupManager> findById(Long id);
    void delete(Long id);

}
