package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/customer")
public class CustomerController  {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private LoginService loginService;
    @GetMapping
    public String test(){
        return "hello world";
    }

    /*@PostMapping("/login")
    public ResponseResult login(HttpServletResponse response, @RequestBody Customer customer){
        QueryWrapper<Customer> wrapper = new QueryWrapper<>();
        wrapper.eq("customerId",customer.getCustomerName())
                .eq("loginPwd",customer.getLoginPwd());
        String token = null;
        Customer customer1 = (Customer) customerMapper.login(customer.getCustomerName(), customer.getLoginPwd());
        if (customer1!=null){
            token = TokenUtil.sign(customer1);
            //成功登录并产生token
        }

        ResponseResult responseResult = new ResponseResult();
        if(token!=null){
            responseResult.setCode(200);
            responseResult.setMessage(token);
            responseResult.setSuccess(true);
            return responseResult;
        }
        responseResult.setCode(400);
        responseResult.setSuccess(false);
        responseResult.setMessage("登录失败，请重试");
        return responseResult;
    }
    */
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

    @PostMapping("/info")
    public Customer getInfo(@Param("customerId")int customerId){
        System.out.println(customerId);
        return customerMapper.getInfo(customerId).get(0);
    }
    /*"customerId": 1,
            "customerName": "zjh",
            "email": "zjh@163.com",
            "birthday":2022-10-10,
            "phone": 123456789,
            "address": "thu"*/
    @PostMapping("/modifyInfo")
    public boolean modifyInfo(@RequestBody Customer customer){
        System.out.println("-----------------");
        System.out.println(customer.getCustomerId());
        System.out.println(customer.getCustomerName());

        return  customerMapper.modifyInfo(customer.getCustomerId(),
                customer.getCustomerName(), customer.getEmail(), customer.getBirthday(),
                customer.getPhone(),customer.getAddress())==1;
    }

    @PostMapping("/checkPwd")
    public boolean checkPwd(@Param("customerId")int customerId,@Param("loginPwd")String loginPwd){
        String realPwd = customerMapper.getPwdById(customerId);
        return Objects.equals(loginPwd, realPwd);
    }


    @PostMapping("/modifyPwd")
    public boolean modifyPwd(@Param("customerId")int customerId,@Param("loginPwd")String loginPwd){
        return customerMapper.updatePwd(customerId,loginPwd)==1;
    }




}
