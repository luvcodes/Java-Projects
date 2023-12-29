package com.example.sys.controller;

import com.example.common.vo.Result;
import com.example.sys.entity.User;
import com.example.sys.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

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


}
