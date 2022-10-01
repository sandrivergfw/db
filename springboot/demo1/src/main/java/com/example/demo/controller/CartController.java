package com.example.demo.controller;

import com.example.demo.entity.Cart;
import com.example.demo.mapper.CartMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartMapper cartMapper;

    /**
     * url传入"http:localhost/9090/cart/?customerId=要查询的customer对应的id
     * 只有customerId是必选项，其他可以不填
     * @param customerId
     * @return
     */
    @PostMapping()
    public List<Cart> selectByCustomerId(@Param("customerId") int customerId){
        return cartMapper.findByCustomerId(customerId);
    }

    /**
     * 返回1表示插入成功
     * @param cart
     * @return
     */
    @PostMapping("/add")
    public int addToCart(@RequestBody Cart cart){
        return cartMapper.insert(cart.getCustomerId(),cart.getProductId(), new Date());
    }

    @PostMapping("/delete")
    public int deleteFromCart(@RequestBody Cart cart){
        return cartMapper.deleteById(cart.getCustomerId(),cart.getProductId());
    }

    @PostMapping("/orderByTime")
    public List<Cart> orderByTime(@RequestParam("order") String order){
        return cartMapper.orderByTimeDesc(order);
    }
}
