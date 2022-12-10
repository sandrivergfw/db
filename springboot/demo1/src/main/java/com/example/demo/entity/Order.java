package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private int orderNo ;
    private int customerId;
    private String orderAddress;
    private Date orderTime;
    private double pay;
}
