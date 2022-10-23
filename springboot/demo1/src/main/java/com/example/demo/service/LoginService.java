package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserType;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.StoreMapper;
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
    @Autowired
    StoreMapper storeMapper;

    /**
     * 进行登录操作，如果用户名和密码正确，使用UUID一个字符串作为token
     * @param userName
     * @param pwd
     * @param userType
     * @return
     */
    public String login(String userName, String pwd, UserType userType) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String rightPwd;
        int id;
        switch (userType){
            case customer: {
                rightPwd = customerMapper.getPwdByName(userName);
                id = customerMapper.getIdByName(userName);
                break;}
            case store:{rightPwd = storeMapper.getPwdByName(userName);
                id = storeMapper.getIdByName(userName);
                break;}
            default:{
                throw new RuntimeException(); //错误的用户类型
            }
        }
        /* TODO */
        /*这是我(zjh)写的吗...为啥毫无印象*/
        /* TODO */
        String token;
        boolean success ;
        if(Objects.equals(pwd, rightPwd)){
            token = TokenUtil.sign(userName);
            redisService.set(token,userName);
            success = true;
        }else {
            token = null;
            success = false;
        }

        //这里onlineCustomer的属性名字改掉了

        OnlineCustomer onlineCustomer = new OnlineCustomer(success,token,id);
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

