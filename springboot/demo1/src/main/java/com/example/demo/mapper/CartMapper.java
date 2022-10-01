package com.example.demo.mapper;

import com.example.demo.entity.Cart;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CartMapper {
    @Select("select * from cartinfor")
    List<Cart> findAll(); //查询所有的user select * from sys_user

    @Select("select * from cartinfor where customerId=#{customerId}")
    List<Cart> findByCustomerId(@Param("customerId")int customerId);
    /**
     * 输入要求
     * order:一个字符串，要求填入DESC或者是ASC（不区分大小写），不能是空
     * @param order
     * @return
     */
    @Select("select * from cartinfor order by createTime ${order}}")
    List<Cart> orderByTimeDesc(@Param("order") String order);

    @Insert("insert into cartinfor(customerId,productId,createTime)  value(#{customerId},#{productId},#{createTime})")
    int insert(@Param("customerId")int customerId, @Param("productId")int productId, @Param("createTime")Date createTime);

    @Delete("delete from cartinfor where customerId = #{customerId} and productId=#{productId}")
    int deleteById(@Param("customerId") int customerId,@Param("productId") int productId); //这三个id最好都一个名字
}
