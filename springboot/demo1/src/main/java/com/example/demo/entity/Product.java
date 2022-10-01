package com.example.demo.entity;

import lombok.Data;

@Data
public class Product {
    private int productId;
    private String productName;
    private String brand;
    private double size;//电脑尺寸
    private int sales;//销量

}
