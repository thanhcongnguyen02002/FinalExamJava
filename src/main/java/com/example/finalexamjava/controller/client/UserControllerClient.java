package com.example.finalexamjava.controller.client;

import com.example.finalexamjava.controller.UserMapper;
import com.example.finalexamjava.controller.UserReq;
import com.example.finalexamjava.controller.UserResp;
import com.example.finalexamjava.model.Role;
import com.example.finalexamjava.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client/user")
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserControllerClient {
    UserService service;
    PasswordEncoder passwordEncoder;
    UserMapper userMapper;
    @PostMapping()
    public UserResp create(@RequestBody UserReq req){
        var user= userMapper.toUser(req);
        user.setUserName(req.userName());
        user.setName(req.name());
        user.setPassword(passwordEncoder.encode(req.password()));
        user.setRole(Role.USER);
        return  userMapper.toUserResp(service.save(user));
    }
}
