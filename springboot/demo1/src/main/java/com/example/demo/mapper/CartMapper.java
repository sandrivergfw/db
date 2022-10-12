package com.example.demo.mapper;

import com.example.demo.entity.Cart;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface CartMapper {
    @Select("select * from cartinfor")
    List<Cart> findAll(); //查询所有的user select * from sys_user

    @Select("select cartinfor.productId, number, productName, brand, price " +
            "from cartinfor, products " +
            "where customerId=#{customerId} and products.productId=cartinfor.productId")
    List<Cart> findByCustomerId(@Param("customerId")int customerId);
    /**
     * 输入要求
     * order:一个字符串，要求填入DESC或者是ASC（不区分大小写），不能是空
     * @param order
     * @return
     */
    @Select("select * from cartinfor order by createTime ${order}}")
    List<Cart> orderByTimeDesc(@Param("order") String order);

    @Insert("insert into cartinfor(customerId,productId,createTime,number)" +
            "  value(#{customerId},#{productId},#{createTime},#{number})")
    int insert(@Param("customerId")int customerId,
               @Param("productId")int productId,
               @Param("createTime")Date createTime,
               @Param("number")int number);
    // 检查是否已经购买
    @Select("select * from cartinfor where customerId=#{customerId} and productId=#{productId}")
    List<Cart> checkIfPurchased(@Param("customerId")int customerId, @Param("productId")int productId);

    @Delete("delete from cartinfor where customerId = #{customerId} and productId=#{productId}")
    int deleteById(@Param("customerId") int customerId,@Param("productId") int productId); //这三个id最好都一个名字
}
