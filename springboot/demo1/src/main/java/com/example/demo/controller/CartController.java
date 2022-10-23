package com.example.demo.controller;

import com.example.demo.relation.Cart;
import com.example.demo.entity.Customer;
import com.example.demo.linkClass.CartProduct;
import com.example.demo.mapper.CartMapper;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.ProductsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ProductsMapper productsMapper;
    @Autowired
    private CustomerMapper customerMapper;

    /* TODO */
    @PostMapping
    public List<CartProduct> getAllCarts(@RequestBody Customer customer){
        System.out.println("customerId: " + customer.getCustomerId());
        return cartMapper.getAllCart(customer.getCustomerId());
    }
    /* TODO */

    @PostMapping("/buyAll")
    public boolean buyAll(@Param("customerId")int customerId){
        List<Cart> carts = cartMapper.getAllSelect(customerId);
        String orderAddress = customerMapper.getAddress(customerId);
        for(Cart cart:carts){
            double pay = productsMapper.getPrice(cart.getProductId());
            Timestamp orderTime = new Timestamp(System.currentTimeMillis());
            orderMapper.insert(customerId, orderAddress, orderTime,pay);
        }
        return cartMapper.deleteAllSelect(customerId) == carts.size();
    }

    @PostMapping("/checkbox")
    public boolean changeCheckbox(@Param("customerId")int customerId,@Param("productId")int productId){
        cartMapper.changeCheckbox(customerId,productId);
        return true;// 判断语句是否执行成功
    }
    @PostMapping("/delProduct")
    public boolean delProduct(@Param("customerId")int customerId,@Param("productId")int productId)
    {
        return  cartMapper.delProduct(customerId,productId)==1;
    }

    @PostMapping("/check")
    public boolean check(@Param("customerId")int customerId,@Param("customerId") int productId){
        return cartMapper.check(customerId,productId).size()==1;
    }

    @PostMapping("/add")
    public boolean add(@Param("customerId")int customerId,@Param("productId")int productId){
        return cartMapper.addProduct(customerId,productId)==1;
    }

    @PostMapping("/plusProduct")
    public boolean plusProductNum(@Param("customerId") int customerId,@Param("productId")int productId){
        int row =  cartMapper.plusProductNum(customerId,productId);
        return row==1;
    }
    
    @PostMapping("/minusProduct")
    public boolean minusProductNum(@Param("customerId") int customerId,@Param("productId")int productId){
        int row =  cartMapper.minusProductNum(customerId,productId);
        return (row==0)||(row==1);
    }


}
