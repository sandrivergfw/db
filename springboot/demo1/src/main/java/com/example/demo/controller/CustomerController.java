package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.OnlineCustomer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.utils.CreateJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping
    public String test(){
        return "hello world";
    }

    @PostMapping("/login")
    public OnlineCustomer login(@RequestBody Customer customer){
        List<Customer> customers = customerMapper.login(customer.getCustomerName(), customer.getLoginPwd());
        if(customers.size()==1){
            OnlineCustomer onCust = new OnlineCustomer(customers.get(0));
            onCust.setToken(CreateJwt.getToken(customer.getCustomerName(),customer.getCustomerId()));
            return onCust;
        }else {
            return null;
        }
    }

    /**
     * 返回1表示注册成功，如果有重名注册不成功
     * @param customer
     * @return
     */

    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer){
        return customerMapper.insert(customer.getCustomerName(), customer.getLoginPwd())==1;
    }

    /**
     * true表示有重名
     * @param customer
     * @return
     */
    @PostMapping("/namecheck")
    public boolean nameCheck(@RequestBody Customer customer){
        return customerMapper.nameCheck(customer.getCustomerName()).size()>0;
    }


}
