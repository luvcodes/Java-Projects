package com.runzeyang.springboot.controller;

import com.runzeyang.springboot.entity.User;
import com.runzeyang.springboot.mapper.UserMapper;
import com.runzeyang.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user") // 给接口加前缀
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    // 更新或者新增, 在UserService里面定义了方法
    @PostMapping
    public Integer save(@RequestBody User user) {

        return userService.save(user);
    }

    // 查询所有数据
    @GetMapping
    public List<User> findAll() {
        return userMapper.findAll();
    }

    // 根据id去删除
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        return userMapper.deleteById(id);
    }
}
