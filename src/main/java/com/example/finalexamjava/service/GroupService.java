package com.example.finalexamjava.service;

import com.example.finalexamjava.controller.GroupFilter;
import com.example.finalexamjava.model.GroupManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    Page<GroupManager> findAll(GroupFilter filter, Pageable pageable);
    Optional<GroupManager> findByName(String name);
    GroupManager createGroup( GroupManager groupManager);
    GroupManager findByGroupName(String name);
    GroupManager findByid(Long id);
    GroupManager save(GroupManager groupManager);
    void delete(Long id);
    GroupManager update( GroupManager groupManager);
}
