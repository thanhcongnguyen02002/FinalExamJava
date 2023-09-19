package com.example.finalexamjava.service;

import com.example.finalexamjava.model.GroupExistedException;
import com.example.finalexamjava.model.GroupManager;
import com.example.finalexamjava.repository.ErrorCode;
import com.example.finalexamjava.repository.GroupRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupServiceImpl implements GroupService {
    GroupRepository repository;


    @Override
    public List<GroupManager> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<GroupManager> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public GroupManager createGroup(GroupManager groupManager) {
        var resutl = findByName(groupManager.getGroupName());
        if (resutl.isPresent()){
           throw new GroupExistedException(ErrorCode.GROUP_EXISTED,"groupname already exists ");
        }
        return repository.save(groupManager);
    }
}
