package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Cart {
    private int customerId;
    private int productId;
    private Date createTime;
    private String productName;
    private String brand;
    private double size;//电脑尺寸
    private int sales;//销量
    private double price;
    private int number; // 购买数量
}
