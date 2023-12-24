package com.runzeyang.springboot.service;

import com.runzeyang.springboot.entity.User;
import com.runzeyang.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ryanw
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        // 这里就是判断在postman里面提供的json是否提供了id
        // 如果没有提供id，那么就是新增; 如果提供了id，那么就是修改
        if (user.getId() == null) {
            return userMapper.insert(user);
        } else {
            return userMapper.update(user);
        }
    }
}
