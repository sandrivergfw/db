package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//一个component 将这个类注入springboot容器 和mapping的作用是一样的
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int save(User user){
        // 插入或更新
        if (user.getId()==null){
            //新增的
            return userMapper.insert(user.getUsername(), user.getPassword());
        }else {
            //更新
            return userMapper.update(user);
        }
    }
}
