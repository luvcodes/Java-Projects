package com.runzeyang.springboot.mapper;

import com.runzeyang.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author ryanw
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_user")
    List<User> findAll();

    @Insert("INSERT INTO sys_user (username, password, nickname, email, phone, address) " +
            "VALUES (#{username}, #{password}, #{nickname}, #{email}, #{phone}, #{address})")
    int insert(User user);

    // 这里没有注解去看User.xml实现动态的sql语句
    int update(User user);

    // sql中的id和@Param括号中的参数要名称相同
    @Delete("DELETE FROM sys_user WHERE id = #{id}")
    Integer deleteById(@Param("id") Integer id);
}
