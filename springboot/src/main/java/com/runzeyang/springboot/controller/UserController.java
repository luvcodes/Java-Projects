package com.runzeyang.springboot.controller;

import com.runzeyang.springboot.entity.User;
import com.runzeyang.springboot.mapper.UserMapper;
import com.runzeyang.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ryanw
 */
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

    // 根据id去删除
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        return userMapper.deleteById(id);
    }

    // 查询所有数据
    @GetMapping
    public List<User> findAll() {
        return userMapper.findAll();
    }

    // 分页查询
    // 接口路径: /user/page?pageNum=1&pageSize=10
    // @RequestParam接受
    @GetMapping("/page")
    public Map<String, Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        pageNum = (pageNum - 1) * pageSize; // 分页的计算公式，(当前页 - 1) * 当前页数据行数
        List<User> data = userMapper.selectPage(pageNum, pageSize);
        Integer total = userMapper.selectTotal();
        Map<String, Object> res = new HashMap<>();
        res.put("data", data);
        res.put("total", total);
        return res;
    }
}
