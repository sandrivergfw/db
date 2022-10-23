package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Store;
import com.example.demo.entity.UserType;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.LoginService;
import com.example.demo.utils.OnlineCustomer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 在controller中对登录和注销方法进行调用
 */
@RestController
@RequestMapping()
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    CustomerMapper customerMapper;

    @ResponseBody
    @PostMapping("/customer/login")
    public String login(@RequestBody Customer customer) throws JsonProcessingException {
        return loginService.login(customer.getCustomerName(), customer.getLoginPwd(),UserType.customer);
    }

    @RequestMapping("/customer/logout")
    public String logout(HttpServletRequest httpServletRequest) {
        return loginService.logout(httpServletRequest);
    }

    @RequestMapping("/deleteCustomer")
    public boolean deleteCustomer(HttpServletRequest httpServletRequest){
        loginService.logout(httpServletRequest);
        return customerMapper.deleteById(Integer.parseInt(httpServletRequest.getParameter("customerId")))==1;
    }

    @ResponseBody
    @PostMapping("/store/login")
    public String login(@RequestBody Store store) throws JsonProcessingException {
        return loginService.login(store.getStoreName(),store.getStorePwd(), UserType.store);
    }

}

