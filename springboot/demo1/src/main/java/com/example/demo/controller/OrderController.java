package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderMapper orderMapper;

    @PostMapping("/all")
    public List<Order> getAll(@Param("customerId")int customerId){
        return orderMapper.findOrderByCustomer(customerId);
    }
    @PostMapping("/deleteById")
    public boolean deleteById(@Param("customerId")int customerId,@Param("orderId")int orderId){
        return orderMapper.deleteById(orderId)==1;
    }
}
