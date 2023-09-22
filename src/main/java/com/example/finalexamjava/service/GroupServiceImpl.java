package com.example.finalexamjava.service;

import com.example.finalexamjava.controller.GroupFilter;
import com.example.finalexamjava.model.GroupExistedException;
import com.example.finalexamjava.model.GroupManager;
import com.example.finalexamjava.model.GroupNotFoundException;
import com.example.finalexamjava.repository.ErrorCode;
import com.example.finalexamjava.repository.GroupRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupServiceImpl implements GroupService {
    GroupRepository repository;
    @Override
    public Page<GroupManager> findAll(GroupFilter filter, Pageable pageable) {
        return repository.findAll(filter, pageable);
    }

    @Override
    public Optional<GroupManager> findByName(String name) {

        return repository.findByName(name);
    }

    @Override
    public GroupManager createGroup(GroupManager groupManager) {
        var resutl = findByName(groupManager.getGroupName());
        if (resutl.isPresent()) {
            throw new GroupExistedException(ErrorCode.GROUP_EXISTED, "groupname already exists ");
        }
        return repository.save(groupManager);
    }

    @Override
    public GroupManager findByGroupName(String name) {
        var resutl = findByName(name);
        if ( !resutl.isPresent()) {
            throw new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND, "GroupName not found with " + name);
        }
        return repository.findByName(name).orElseThrow();
    }

    @Override
    public GroupManager findByid(Long id) {

        return  repository.findById(id)
                .orElseThrow(() -> new GroupNotFoundException(ErrorCode.GROUP_NOT_FOUND, "group id not found with "+id));
    }

    @Override
    public GroupManager save(GroupManager groupManager) {
        return repository.save(groupManager);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public GroupManager update(GroupManager groupManager) {
        return repository.save(groupManager);
    }
}

