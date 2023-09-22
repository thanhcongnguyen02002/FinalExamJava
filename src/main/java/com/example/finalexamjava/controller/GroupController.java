package com.example.finalexamjava.controller;

import com.example.finalexamjava.model.GroupManager;
import com.example.finalexamjava.service.GroupService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Validated

public class GroupController {
    GroupService service;
    GroupMapper mapper;
    @GetMapping
    public Page<GroupResp> findAll(@ModelAttribute GroupFilter filter, Pageable pageable){
        return service.findAll(filter, pageable).map(mapper::toGroupResp);
    }
    @GetMapping("/{name}")
    public GroupResp findByName(@PathVariable String name){
        return service.findByGroupName(name).transform(mapper::toGroupResp);
    }
    @GetMapping("/{id}")
    public  GroupResp findByID(@PathVariable Long id){
        return service.findByid(id).transform(mapper::toGroupResp);
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public GroupResp create(@RequestBody @Valid GroupReq req){
        return req.transform(mapper:: toGroupManager)
                .transform(service::createGroup)
                .transform(mapper::toGroupResp);
    }
    @PatchMapping("{id}/update")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public GroupResp update(@PathVariable Long id, @RequestBody @Valid GroupUpdateResp req){
        var exists = service.findByid(id);
        mapper.update(req, exists);
        return exists.transform(service::createGroup)
                .transform(mapper::toGroupResp);
    }
    @DeleteMapping("/disable-batch")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deleteList(@RequestBody List<Long> ids) {
        ids.forEach(
                id -> service.delete(id)

        );

    }

}
