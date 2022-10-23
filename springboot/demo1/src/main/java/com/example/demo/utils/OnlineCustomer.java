package com.example.demo.utils;

import lombok.Data;

@Data
public class OnlineCustomer {
    boolean success;
    String token;
    Integer userId;

    public OnlineCustomer(boolean success,String token,Integer userId) {
        this.success = success;
        this.token = token;
        this.userId = userId;
    }


}
