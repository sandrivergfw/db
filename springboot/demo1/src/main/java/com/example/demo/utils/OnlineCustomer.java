package com.example.demo.utils;

import lombok.Data;

@Data
public class OnlineCustomer {
    boolean success;
    String token;
    Integer customerId;

    public OnlineCustomer(boolean success,String token,Integer customerId) {
        this.success = success;
        this.token = token;
        this.customerId = customerId;
    }


}
