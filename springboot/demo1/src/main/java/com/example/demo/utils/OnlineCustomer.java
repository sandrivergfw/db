package com.example.demo.utils;

import lombok.Data;

@Data
public class OnlineCustomer {
    boolean success;
    String token ;

    public OnlineCustomer(boolean success,String token) {
        this.success = success;
        this.token = token;
    }


}
