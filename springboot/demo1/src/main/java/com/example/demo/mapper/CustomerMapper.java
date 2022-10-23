package com.example.demo.mapper;

import com.example.demo.entity.Customer;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CustomerMapper {
    @Select("select * from customers")
    List<Customer> findAll(); //查询所有的user select * from sys_user

    @Select("select address from customers where customerId=#{customerId}")
    String getAddress(int customerId);

    /* TODO */
    @Select("select customerId from customers where customerName = #{customerName}")
    Integer getIdByName(String customerName);
    /* TODO */

    @Select("select * from customers where customerName = #{customerName}")
    List<Customer> nameCheck(@Param("customerName") String customerName);

    @Select("select * from customers where customerName = #{customerName} and loginPwd = #{loginPwd}")
    List<Customer> login(@Param("customerName") String customerName,@Param("loginPwd") String loginPwd);

    @Insert("INSERT INTO customers(customerName,loginPwd) VALUES(#{customerName},#{loginPwd})")
        //#{}占位符传参
    int insert(@Param("customerName") String customerName,@Param("loginPwd")String loginPwd);

    @Delete("delete from customers where customerId = #{customerId}")
    int deleteById(@Param("customerId") int customerId); //这三个id最好都一个名字
    // 注解和动态.xml文件二选一
    //增删改查
    @Delete("delete from customers where customerName = #{customerName}")
    int deleteByName(@Param("customerName") int customerName); //这三个id最好都一个名字

    @Select("SELECT * FROM customers where customerId= #{customerId}")
    List<Customer> getInfo(@Param("customerId") int customerId);

    int modifyInfo(@Param("customerId") int customerId,@Param("customerName") String customerName,
                   @Param("email") String email,@Param("birthday") Date birthday,@Param("phone") String phone,@Param("address") String address);

    @Select("select loginPwd from customers where customerId=#{customerId}")
    String getPwdById(@Param("customerId") int customerId);

    @Select("select loginPwd from customers where customerName=#{customerName}")
    String getPwdByName(@Param("customerName") String customerName);

    @Update("update customers set loginPwd=#{loginPwd} where customerId=#{customerId}")
    int updatePwd(@Param("customerId") int customerId,@Param("loginPwd") String loginPwd);

    @Update("update customers set picWay=#{picWay} where customerId=#{customerId}")
    int updatePicWay(@Param("picWay") String picWay,@Param("customerId") int customerId);

    @Select("select picWay from customers where customerId=#{customerId}")
    String getPicWay(@Param("customerId")int customerId);
}
