package com.example;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ryanw
 */
@SpringBootApplication
@MapperScan("com.example.*.mapper")
public class SpringbootAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdminApplication.class, args);
    }
}
