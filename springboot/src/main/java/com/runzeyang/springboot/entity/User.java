package com.runzeyang.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    @JsonIgnore // 忽略password在浏览器控制台
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;

}
