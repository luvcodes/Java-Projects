package com.example.sys.service;

import com.example.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ryanyang
 * @since 2023-12-29
 */
public interface IUserService extends IService<User> {

    Map<String, Object> login(User user);
}
