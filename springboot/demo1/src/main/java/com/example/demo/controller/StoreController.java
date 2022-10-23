package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Store;
import com.example.demo.mapper.StoreMapper;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController  //组合注解 是GetMapping的基础
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public boolean register(@RequestBody Store store){

        //检查是否有重名的
        return storeMapper.insert(store.getStoreName(), store.getStorePwd())==1;
    }

}
