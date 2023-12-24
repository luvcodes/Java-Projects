package com.runzeyang.springboot.mapper;

import com.runzeyang.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ryanw
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_user")
    List<User> findAll();
}
