package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.example.demo.utils.CreateJwt;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/user") //统一给接口加前缀 查询的相对url起始点变成了localhost:9090/user
public class UserController {
    @Autowired  //注入其他类的注解
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    //在浏览器中直接通过URL访问是一种get请求
    @GetMapping() //一个注解，服务器端通过相对url向客户端返回数据
    public List<User> index(){
        List<User> users= userMapper.findAll();

        return users;
    }//这个查询时静态的，不需要客户端进行请求，自动将数据库中的数据以json文件返回到url对应的web端

    //post请求:客户端向服务器端发送数据进行crud操作
    @PostMapping
    public Integer save(@RequestBody User user){
        //@RequestBody注解:前台传入json数据的时候将json转为User实体对象
        return userService.save(user);
    }

    @PostMapping("/login")
    public Map<Integer,String> login(@RequestBody User user){
        System.out.println("login receive username : "+user.getUsername()+" password: "+user.getPassword());
        List<User> users = userMapper.login(user.getUsername(), user.getPassword());
        Map<Integer,String> map = new HashMap<>();
        if(users.size()==1){
            map.put(1,CreateJwt.getToken(user.getUsername(),user.getId()));
        }else {
            map.put(0,"error");
        }
        return map;
    }

    @PostMapping("/register")
    public Integer register(@RequestBody User user){

        return userMapper.insert(user.getUsername(), user.getPassword());
    }

    @PostMapping("/namecheck")
    public Integer nameCheck(@RequestBody User user){
        return userMapper.nameCheck(user.getUsername()).size();
    }

    @DeleteMapping("/{id}") //这俩注解是对应的
    public Integer delete(@PathVariable Integer id){ //PathVariable表示url参数
        return userMapper.deleteById(id);
    }



}
