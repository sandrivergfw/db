package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 实体类
// lombok插件提供了很多有用的注解
@Data  //引入这个注解替代大量的getter setter
//@NoArgsConstructor //创建无参构造
//@AllArgsConstructor //有参构造
public class User {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String email;
    private String phone;
    private String address;
}
