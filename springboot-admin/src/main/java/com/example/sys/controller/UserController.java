package com.example.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.vo.Result;
import com.example.sys.entity.User;
import com.example.sys.service.IUserService;
import org.springframework.util.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ryanyang
 * @since 2023-12-29
 */
@RestController
@RequestMapping("/user")
//@CrossOrigin // 跨域处理
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/all")
    public Result<List<User>> getALlUser() {
        List<User> users = iUserService.list();
        return Result.success(users, "查询成功");
    }

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody User user) {

        Map<String, Object> data = iUserService.login(user);

        if (data != null) {
            return Result.success(data, "登录成功");
        }

        return Result.fail(20002, "用户名或密码错误");
    }

    @GetMapping("/info")
    public Result<?> getUserInfo(@Param("token") String token){
        Map<String,Object> data = iUserService.getUserInfo(token);
        if(data != null){
            System.out.println("User details: " + data);
            return Result.success(data);
        }
        return Result.fail(20003,"用户信息获取失败");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token){
        iUserService.logout(token);
        return Result.success("注销成功");
    }

    @GetMapping("/list")
    public Result<Map<String, Object>> getUserList(@RequestParam (value = "username", required = false) String username,
                                               @RequestParam (value = "phone", required = false) String phone,
                                               @RequestParam (value = "pageNo") Long pageNo,
                                               @RequestParam (value = "pageSize") Long pageSize) {
        // 实现分页查询
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 使用LambdaQueryWrapper是因为这样获取字段的时候就不用写字符串了，直接获取字段，这样就不会写错了。
        // 第三个参数就是传进来的属性
        wrapper.eq(StringUtils.hasLength(username), User::getUsername, username);
        wrapper.eq(StringUtils.hasLength(phone), User::getPhone, phone);

        // 分页
        Page<User> page = new Page<>(pageNo, pageSize);
        iUserService.page(page, wrapper);

        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal()); // 跟前端的名字保持统一
        data.put("rows", page.getRecords()); // 跟前端的名字保持统一

        return Result.success(data, "查询成功");
    }


    @PostMapping
    public Result<?> addUser(@RequestBody User user) {
        iUserService.save(user);
        return Result.success("添加成功");
    }
}
