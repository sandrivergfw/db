package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.utils.OnlineCustomer;
import com.example.demo.utils.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginService {

    @Autowired
    RedisService redisService;

    @Autowired
    CustomerMapper customerMapper;

    /**
     * 进行登录操作，如果用户名和密码正确，使用UUID一个字符串作为token
     * @param customerName
     * @param loginPwd
     * @return
     */
    public String login(String customerName, String loginPwd) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("loginservice: "+customerName+" pwd:"+loginPwd);
        String rightPwd = customerMapper.getPwdByName(customerName);
        String token;
        boolean success ;
        if(Objects.equals(loginPwd, rightPwd)){
            token = TokenUtil.sign(customerName);
            redisService.set(token,customerName);
            success = true;
        }else {
            token = null;
            success = false;
        }

        OnlineCustomer onlineCustomer = new OnlineCustomer(success,token);
        return objectMapper.writeValueAsString(onlineCustomer);
    }

    /**
     * 进行注销操作，实质是删除redis和token中的缓存
     * @param httpServletRequest
     * @return
     */
    public String logout(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        boolean delete = redisService.delete(token);
        if (delete){
            return "注销成功";
        }else {
            return "注销失败";
        }
    }


}

