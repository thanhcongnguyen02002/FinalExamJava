package com.example.finalexamjava.service;

import com.example.finalexamjava.model.GroupManager;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    List<GroupManager> findAll();
    Optional<GroupManager> findByName(String name);
    GroupManager createGroup( GroupManager groupManager);
}
