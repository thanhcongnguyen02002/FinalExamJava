package com.example.finalexamjava.controller;

import com.example.finalexamjava.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResp toUserResp(User user);
    User toUser(UserReq userReq);

}
