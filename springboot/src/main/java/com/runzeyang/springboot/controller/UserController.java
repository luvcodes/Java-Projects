package com.runzeyang.springboot.controller;

import com.runzeyang.springboot.entity.User;
import com.runzeyang.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public List<User> hello() {
        return userMapper.findAll();
    }
}
