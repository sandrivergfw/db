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

    /*
    @PostMapping()
    public List<Cart> selectByCustomerId(@RequestBody Cart cart){
        //System.out.println(customerId);
        return cartMapper.findByCustomerId(cart.getCustomerId());
    }*/
    @PostMapping()
    public List<Cart> selectByCustomerId(@RequestBody Cart cart){
        //System.out.println(customerId);
        return cartMapper.findByCustomerId(cart.getCustomerId());
    }

    @PostMapping("/add")
    public boolean addToCart(@RequestBody Cart cart){
        return cartMapper.insert(cart.getCustomerId(),cart.getProductId(), new Date(), 1)==1;
    }

    @PostMapping("/check")
    public boolean checkTheCart(@RequestBody Cart cart){
        return cartMapper.checkIfPurchased(cart.getCustomerId(),cart.getProductId()).size()!=0;
    }

    @PostMapping("/delete")
    public boolean deleteFromCart(@RequestBody Cart cart){
        return cartMapper.deleteById(cart.getCustomerId(),cart.getProductId())==1;
    }

    @PostMapping("/orderByTime")
    public List<Cart> orderByTime(@RequestParam("order") String order){
        return cartMapper.orderByTimeDesc(order);
    }
}
