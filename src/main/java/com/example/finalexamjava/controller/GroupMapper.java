package com.example.finalexamjava.controller;

import com.example.finalexamjava.model.GroupManager;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupResp toGroupResp(GroupManager groupManager);
    GroupManager toGroupManager(GroupReq groupReq);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(GroupUpdateResp req, @MappingTarget GroupManager groupManager);
}
