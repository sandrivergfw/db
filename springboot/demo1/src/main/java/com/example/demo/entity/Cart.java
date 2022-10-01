package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Cart {
    private int cartId;
    private int customerId;
    private int productId;
    private Date createTime;
}
