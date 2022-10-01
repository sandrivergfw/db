package com.example.demo.mapper;

import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface CustomerMapper {
    @Select("select * from customer")
    List<Customer> findAll(); //查询所有的user select * from sys_user

    @Select("select * from customer where customerName = #{customerName}")
    List<Customer> nameCheck(@Param("customerName") String customerName);

    @Select("select * from customer where customerName = #{customerName} and loginPwd = #{loginPwd}")
    List<Customer> login(@Param("customerName") String customerName,@Param("loginPwd") String loginPwd);

    @Insert("INSERT INTO customer(customerName,loginPwd) VALUES(#{customerName},#{loginPwd}) WHERE (select count(customerName) from customer where customerName=#{customerName}}))")
        //#{}占位符传参
    int insert(@Param("customerName") String customerName,@Param("loginPwd")String loginPwd);

    @Update("UPDATE customer SET customerName=#{customerName},loginPwd=#{loginPwd},payPwd=#{payPwd}," +
            "sex=#{sex},phone=#{phone},address=#{address},birthday=#{birthday},email=#{email} WHERE customerId=#{customerId}")
    int update(Customer customer);

    @Delete("delete from customer where customerId = #{customerId}")
    int deleteById(@Param("customerId") int customerId); //这三个id最好都一个名字
    // 注解和动态.xml文件二选一
    //增删改查
    @Delete("delete from customer where customerName = #{customerName}")
    int deleteByName(@Param("customerName") int customerName); //这三个id最好都一个名字



}
