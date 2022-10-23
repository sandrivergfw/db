package com.example.demo.mapper;

import com.example.demo.entity.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreMapper {
    @Select("select storeId from stores where storeName = #{storeName}")
    Integer getIdByName(@Param("storeName")String storeName);

    @Select("select storeId from stores where storeName = #{storeName}")
    List<Integer> namecheck(@Param("storeName")String storeName);

    @Insert("INSERT INTO stores(storeName,storePwd) VALUES(#{storeName},#{storePwd})")
        //#{}占位符传参
    int insert(@Param("storeName") String storeName,@Param("storePwd")String storePwd);

    @Delete("delete from stores where storeId = #{storeId}")
    int deleteById(@Param("storeId") int storeId); //这三个id最好都一个名字

    @Select("select * from  stores where storeId= #{storeId}")
    List<Customer> getInfo(@Param("storeId") int storeId);

    @Select("select storePwd from stores where storeId=#{storeId}")
    String getPwdById(@Param("storeId") int storeId);

    @Select("select storePwd from stores where storeName=#{storeName}")
    String getPwdByName(@Param("storeName") String storeName);

    @Update("update stores set storePwd=#{storePwd} where storeId=#{storeId}")
    int updatePwd(@Param("storeId") int storeId,@Param("storePwd") String storePwd);

}
