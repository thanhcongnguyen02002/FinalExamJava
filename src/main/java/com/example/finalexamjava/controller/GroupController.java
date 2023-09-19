package com.example.finalexamjava.controller;

import com.example.finalexamjava.model.GroupManager;
import com.example.finalexamjava.service.GroupService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GroupController {
    GroupService service;
    @GetMapping
    public List<GroupManager> findAll(){
        return service.findAll();
    }
    @GetMapping("{name}")
    public GroupManager findByName(@PathVariable String name){
        return service.findByGroupName(name);
    }
    @PostMapping
    public GroupManager create(@RequestBody GroupManager groupManager){
        return service.createGroup(groupManager);
    }
}
