package com.example.demo.mapper;
//数据库查询接口，专门与数据库进行信息交互

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//需要被@Mapper注解才能被springboot所管理:将usermapper的bean注册一下
//否则会出现该类没有在bean中注册的错误
@Mapper
public interface UserMapper {
    // mybatis提供的注解 select注解执行SQL语句
    //mybatis ORM框架 :操作数据库的框架
    @Select("select * from sys_user")
    List<User> findAll(); //查询所有的user select * from sys_user

    @Select("select * from sys_user where username = #{username}")
    List<User> nameCheck(@Param("username") String username);
    @Select("select * from sys_user where username = #{username} and password = #{password}")
    List<User> login(@Param("username") String username,@Param("password") String password);


    @Insert("INSERT INTO sys_user(username,password) VALUES(#{username},#{password})")
    //#{}占位符传参
    int insert(@Param("username") String username,@Param("password")String password);

    int update(User user);

    @Delete("delete from sys_user where id = #{id}")
    int deleteById(@Param("id") int id); //这三个id最好都一个名字
    // 注解和动态.xml文件二选一
    //增删改查





}
