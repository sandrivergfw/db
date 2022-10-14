package com.example.demo.mapper;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO orders SET customerId=#{customerId},orderAddress=#{orderAddress},orderTime=#{orderTime},pay=#{pay}")
    public int insert(@Param("customerId") int customerId,@Param("orderAddress") String orderAddress,@Param("orderTime") Date orderTime,@Param("pay") double pay);

    @Select("SELECT * FROM orders WHERE customerId=#{customerId}")
    public List<Order> findOrderByCustomer(@Param("customerId") int customerId);

    @Delete("delete from orders where orderId=#{orderId}")
    public int deleteById(@Param("orderId")int orderId);

}
