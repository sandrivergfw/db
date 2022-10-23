package com.example.demo.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Order {
    private int orderNo ;
    private int customerId;
    private String orderAddress;
    private Timestamp orderTime;
    private double pay;
}
